package com.spr.reactivexo.rxjava.ch01;

import io.reactivex.rxjava3.core.Observable;

public class FirstExample {

    public void emit(){
        Observable.just("Hello" , "RxJava3.0!").subscribe(System.out::println);
    }

    public static void main(String[] args) {
        FirstExample f = new FirstExample();
        f.emit();
    }
}
