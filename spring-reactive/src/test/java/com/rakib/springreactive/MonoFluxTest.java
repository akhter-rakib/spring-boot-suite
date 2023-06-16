package com.rakib.springreactive;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*Mono and Flux act as a publisher*/
@Slf4j
public class MonoFluxTest {

    @Test
    public void testMono() {
        /*Mono Can handle only one element*/
        /*To Access any publisher the subscriber need to call subscribe method of the publisher*/
        Mono<String> stringMono = Mono
                .just("Hello EveryOne")
                .log();
        /*To see the Mono is following reactive Stream workflow*/
        stringMono.subscribe(log::info); /*Printing published event*/
    }
    /*If publisher publish n number of event whether we are getting n number of onNext call*/
    @Test
    public void testFlux() {
        Flux<String> stringFlux = Flux.just("Hello", "HI", "What", "When")
                .concatWith(Flux.error(new RuntimeException("Exception Occurring")))
                .concatWithValues("This will not Execute. Surcease last onNext method is providing runtime execution")
                .log();
        stringFlux.subscribe(log::info); /*While calling the subscribe method
        It will immediately start emitting the event. Here it will emmit 4 event*/
    }
}
