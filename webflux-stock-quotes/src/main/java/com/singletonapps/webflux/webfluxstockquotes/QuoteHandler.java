package com.singletonapps.webflux.webfluxstockquotes;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class QuoteHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {

        return ok().contentType(TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello Webflux!!"));
    }

    public Mono<ServerResponse> echo(ServerRequest request) {

        return ok().contentType(TEXT_PLAIN)
                .body(request.bodyToMono(String.class), String.class);
    }

}
