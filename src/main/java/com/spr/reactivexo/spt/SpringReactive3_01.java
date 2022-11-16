package com.spr.reactivexo.spt;

import reactor.core.publisher.Mono;

public class SpringReactive3_01 {

    public static void main(String[] args) throws InterruptedException {
        final Mono<String> mono = Mono.just("hello");

        Thread t = new Thread(() -> {
            mono.map(msg -> msg +"thread")
                    .subscribe(v -> System.out.println(v +" : "+ Thread.currentThread().getName())
                    );
        });

        t.start();
        t.join();
    }
}
