package com.reactive.Reactive.Project.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class FluxService {

    public Flux<String> getFlux() {
        return Flux.just("A", "B", "C").log();

    }

}
