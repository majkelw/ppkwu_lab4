package com.ppkwu.lab4.services;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ClientService {

    private final WebClient webClient = WebClient.create("http://localhost:8081");

    public Mono<String> getResponse(String requiredFormatParam, String strParam) {
        return webClient
                .get()
                .uri("/api/{requiredFormatParam}/string?str={strParam}", requiredFormatParam, strParam)
                .retrieve()
                .bodyToMono(String.class);
    }

}
