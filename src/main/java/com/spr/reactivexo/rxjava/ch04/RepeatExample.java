package com.spr.reactivexo.rxjava.ch04;

import com.spr.reactivexo.rxjava.Log;
import io.reactivex.rxjava3.core.Observable;

public class RepeatExample {

    //무한반복자

    public static void main(String[] args) {
        String[] balls = {"1","3","5"};
        Observable<String> source = Observable.fromArray(balls)
                .repeat();
        source.doOnComplete(() -> Log.d("onComplete"))
                .subscribe(Log::i);

    }
}
