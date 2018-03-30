package com.singletonapps.webflux.tradingservice.controller;

import com.singletonapps.webflux.tradingservice.model.TradingUser;
import com.singletonapps.webflux.tradingservice.repository.TradingUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@WebFluxTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private TradingUserRepository tradingUserRepository;

    @Test
    public void listUsers() {
        TradingUser aria = new TradingUser("1", "astark", "Aria Stark");
        TradingUser rob = new TradingUser("2", "rstark", "Rob Stark");

        BDDMockito.given(this.tradingUserRepository.findAll())
                .willReturn(Flux.just(aria, rob));

        this.webTestClient.get().uri("/users").accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectBodyList(TradingUser.class)
                .hasSize(2)
                .contains(aria, rob);

    }

    @Test
    public void showUser() {
        TradingUser jhon = new TradingUser("1", "jsnow", "jsnow");

        BDDMockito.given(this.tradingUserRepository.findByUserName("jsnow"))
                .willReturn(Mono.just(jhon));

        this.webTestClient.get().uri("/users/jsnow").accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectBody(TradingUser.class)
                .isEqualTo(jhon);
    }

}
