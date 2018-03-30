package com.singletonapps.webflux.tradingservice;

import com.singletonapps.webflux.tradingservice.model.TradingUser;
import com.singletonapps.webflux.tradingservice.repository.TradingUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Component
public class UserCommandLinRunner implements CommandLineRunner {

    private TradingUserRepository tradingUserRepository;

    public UserCommandLinRunner(TradingUserRepository tradingUserRepository) {
        this.tradingUserRepository = tradingUserRepository;
    }

    @Override
    public void run(String... args) {

        List<TradingUser> users = Arrays.asList(
                new TradingUser("astark", "Aria Stark"),
                new TradingUser("jsnow", "Jhon Snow"),
                new TradingUser("rstark", "Rob Stark"),
                new TradingUser("sdw", "Shadow"),
                new TradingUser("jlannister", "Jamie Lannister"),
                new TradingUser("dtargarien", "Danearys Targarien"),
                new TradingUser("jmormont", "Jhora Mormont")
        );

        this.tradingUserRepository.insert(users).blockLast(Duration.ofSeconds(3));

    }
}
