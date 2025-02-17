package com.reactive.Reactive.Project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.time.Duration;

@SpringBootTest
class ReactiveProjectApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void wokingWithMono() {
        // Created Mono
        Mono<String> error = Mono.error(new RuntimeException("Error"));
        Mono<String> m1 = Mono
                .just("Hello World!")
                .log()
                .then(error);


        //Consumed Mono
        m1.subscribe(data -> System.out.println("data: " + data));
        error.subscribe(data -> System.out.println("error: " + data));

    }

    @Test
    void practiceMono() throws InterruptedException {
        Mono<String> m1 = Mono.just("Hello World!").delayElement(Duration.ofSeconds(2));
        Mono<String> m2 = Mono.just("I'm Rohit.");

//        Mono<Tuple2<String, String>> combined = Mono.zip(m1, m2);
//        combined.subscribe(data -> System.out.println("data: " + data));
//        combined.subscribe(data -> System.out.println("data: " + data));

        // ++++++++++ Map() ++++++++++++
        // It returns Mono

//        Mono<String> result = m1.map(item -> item.toUpperCase());
//        result.subscribe(data -> System.out.println("data: " + data));

        // ++++++++++ flatMap() ++++++++++++
// It returns Mono


        //Mono<String[]> resultFlat = m1.flatMap(valueM1 -> Mono.just(valueM1.split(" ")));
//        resultFlat.subscribe(data -> {
//            for (String s : data) {
//                System.out.println(s);
//            }
//        });

//        Mono<String[]> resultFlat = m2.flatMap(valueM2 -> Mono.just(valueM2.split("")));
//        resultFlat.subscribe(data -> {
//            for (String s : data) {
//                System.out.println(s);
//            }
//        });

        // ++++++++++ flatMapMany() ++++++++++++
//It returns Flux
//        Flux<String> flatMany = m1.flatMapMany(valueM1 -> Flux.just(valueM1.split("")).log());
//        flatMany.subscribe(data -> System.out.println("data: " + data));

//        m1.;
        m1.subscribe(data ->
        {
            System.out.println("data: " + data);
            System.out.println("thread " + Thread.currentThread().getName());
        });
        Thread.sleep(2000);
    }
}
