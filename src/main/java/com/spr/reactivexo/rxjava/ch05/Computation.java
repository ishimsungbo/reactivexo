package com.spr.reactivexo.rxjava.ch05;

import com.spr.reactivexo.rxjava.CommonUtils;
import com.spr.reactivexo.rxjava.Log;
import com.spr.reactivexo.rxjava.Shape;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Computation {
    public static void main(String[] args) {

        //System.out.println("===============");

        String[] orgs = {"1","3","5"};
        Observable<String> source = Observable.fromArray(orgs)
                //.doOnNext(data -> System.out.println("값은 : " + data))
                .zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS), (a, b)-> a);
        //source.subscribe(d-> System.out.println("여기는 : " + d));
        //source.subscribe(Log::i);

        // 구독 #1
        source.map(item -> "<<" + item + ">>")
                .subscribeOn(Schedulers.computation())
                .subscribe(Log::i);

        // 구독 #2
        source.map(item -> "##" + item + "##")
                .subscribeOn(Schedulers.computation())
                .subscribe(Log::i);

        CommonUtils.sleep(500);

    }
}
