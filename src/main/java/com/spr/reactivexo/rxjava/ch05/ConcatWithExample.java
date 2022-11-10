package com.spr.reactivexo.rxjava.ch05;

import io.reactivex.rxjava3.core.Observable;

/**
 * ConcatWith 는 또다른 옵저버블을 결합할 수 있다.
 */
public class ConcatWithExample {

    public static void main(String[] args) {
        Observable<Integer> o = Observable.just(1,2,3,4)
                //.doOnNext(System.out::println)
                .concatWith(Observable.just(5,6,7,8));
                //.doOnNext(System.out::println);

        o.subscribe(System.out::println);
    }

}
