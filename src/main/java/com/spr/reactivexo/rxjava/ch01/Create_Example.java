package com.spr.reactivexo.rxjava.ch01;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;

public class Create_Example {
    public static void main(String[] args) {
        /**
         * create 는 개발자가 직접 onNext, onComplete, onError 같은 알림을 개발자가 직접 호출해야 한다.
         */
        Observable<Integer> source = Observable.create(
                (ObservableEmitter<Integer> emmiter) ->{
                    emmiter.onNext(100);
                    emmiter.onNext(200);
                    emmiter.onNext(300);
                    emmiter.onNext(400);
                    emmiter.onNext(500);
                    emmiter.onComplete();
                }
        );

        source.subscribe(System.out::println);
    }
}
