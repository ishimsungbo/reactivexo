package com.spr.reactivexo.rxjava.ch04;

import com.spr.reactivexo.rxjava.Log;
import io.reactivex.rxjava3.core.Observable;

public class Example_range {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.range(1,10)
                .filter(number -> number % 2 == 0);

        /**
        1 ~ 10 까지 숫자를 발행하고,
         필터 함수를 통해 짝수만 걸러낸다.
         */
        observable.subscribe(Log::i);
    }
}
