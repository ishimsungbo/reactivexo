package com.spr.reactivexo.rxjava.ch01;


import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Future_ex {
    public static void main(String[] args) {

        System.out.println("쓰레드 1 : " + Thread.currentThread().getName());

        Future<String> future = Executors.newSingleThreadExecutor().submit(()->{
            Thread.sleep(1000);
            System.out.println("쓰레드 2 : " + Thread.currentThread().getName());
            return "Hello Future";
        });

        Observable<String> source = Observable.fromFuture(future);
        source.subscribe(System.out::println);
        future.isDone();

    }
}
