package com.ppkwu.lab4.services;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ClientService {

    private final WebClient webClient = WebClient.create("http://localhost:8081");

    public Mono<String> getStringStats(String downloadFormatParam, String strParam) {
        return webClient
                .get()
                .uri("/api/{download_format_param}/string?str={str_param}", downloadFormatParam, strParam)
                .retrieve()
                .bodyToMono(String.class);
    }

}
