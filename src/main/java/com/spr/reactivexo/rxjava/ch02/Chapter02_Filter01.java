package com.spr.reactivexo.rxjava.ch02;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;


public class Chapter02_Filter01 {
    public static void main(String[] args) {
        String[] objs = {"1 CIRCLE","2 DIAMOND","3 TRIANGLE","4 DIAMOND","5 CIRCLE","6 HEXAGON"};
        Observable<String> source = Observable.fromArray(objs)
                .filter(obj -> obj.endsWith("CIRCLE"));

        source.subscribe(System.out::println);
        
        System.out.println("Srping WebFlux 로 해보기");
        
        Flux<String> flux = Flux.fromArray(objs)
                .filter(o -> o.endsWith("CIRCLE"));

        flux.subscribe(System.out::println);

    }
}
