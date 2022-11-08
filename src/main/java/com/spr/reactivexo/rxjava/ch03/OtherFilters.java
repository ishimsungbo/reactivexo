package com.spr.reactivexo.rxjava.ch03;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class OtherFilters {
    public static void main(String[] args) {

        Integer[] numbers = {100,200,300,400,500};
        Single<Integer> single;
        Observable<Integer> source;

        // filter 와 비슷한 함수들.

        //1. first
        single = Observable.fromArray(numbers).first(-1);
        single.subscribe(value -> System.out.println("1.first method : " + value));

        System.out.println("-------------------------------------------------------");

        single = Observable.fromArray(numbers).last(999);
        single.subscribe(value -> System.out.println("2.last method : " + value));

        System.out.println("-------------------------------------------------------");

        source = Observable.fromArray(numbers).take(3);
        source.subscribe(data -> System.out.println("3.take method : " + data));

        System.out.println("-------------------------------------------------------");

        source = Observable.fromArray(numbers).takeLast(3);
        source.subscribe(data -> System.out.println("4.takeLast method : " + data));

        System.out.println("-------------------------------------------------------");

        source = Observable.fromArray(numbers).skip(2);
        source.subscribe(data -> System.out.println("5.skip method : " + data));

        System.out.println("-------------------------------------------------------");

        source = Observable.fromArray(numbers).skipLast(2);
        source.subscribe(data -> System.out.println("6.skipLast method : " + data));

    }
}
