package com.singletonapps.webflux.tradingservice.repository;

import com.singletonapps.webflux.tradingservice.model.TradingUser;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface TradingUserRepository extends ReactiveMongoRepository<TradingUser, String> {

    Mono<TradingUser> findByUserName(String userName);
}
