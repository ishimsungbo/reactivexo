package com.spr.reactivexo.rxjava.ch03;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;

public class Reduce_Example {
    public static void main(String[] args) {
        String[] balls = {"1","3","5"};
        Maybe<String> source = Observable.fromArray(balls)
                //.reduce((ball1,ball2)-> ball2 + "(" + ball1 + ")"); // 책의 예제
                .map(data -> Integer.valueOf(data))
                .reduce((ball1,ball2)-> ball1 + ball2)
                .map(data -> String.valueOf(data));

        source.subscribe(System.out::println);
    }
}
