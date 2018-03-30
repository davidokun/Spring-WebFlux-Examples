package com.singletonapps.webflux.tradingservice.controller;

import com.singletonapps.webflux.tradingservice.model.TradingUser;
import com.singletonapps.webflux.tradingservice.repository.TradingUserRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    private final TradingUserRepository tradingUserRepository;

    public UserController(TradingUserRepository tradingUserRepository) {
        this.tradingUserRepository = tradingUserRepository;
    }

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<TradingUser> listUsers() {
        return tradingUserRepository.findAll();
    }

    @GetMapping(path = "/users/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TradingUser> showUsers(@PathVariable String username) {
        return this.tradingUserRepository.findByUserName(username);
    }
}
