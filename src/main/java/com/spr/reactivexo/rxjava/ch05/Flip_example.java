package com.spr.reactivexo.rxjava.ch05;

import com.spr.reactivexo.rxjava.CommonUtils;
import com.spr.reactivexo.rxjava.Log;
import com.spr.reactivexo.rxjava.Shape;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Flip_example {
    public static void main(String[] args) {
        String[] objs = {"1-S","2-T","3-P"};
        Observable<String> source = Observable.fromArray(objs)
                .doOnNext(data -> Log.v("Original data = " + data))
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .map(Shape::flip);

        source.subscribe(Log::i);
        CommonUtils.sleep(500);

        /**
         * subscribeOn 구독자가 구독할때 실행되는 쓰레드를 지정
         * observeOn 생성한 데이터 흐름이 어느 쓰레드에서 실행될지 지정할 수가 있다.
         * 쓰레드를 지정하지 않으면 MAIN 쓰레드에서 실행이된다.
         */
    }
}
