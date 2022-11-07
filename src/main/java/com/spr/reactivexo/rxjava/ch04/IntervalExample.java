package com.spr.reactivexo.rxjava.ch04;

import com.spr.reactivexo.rxjava.CommonUtils;
import com.spr.reactivexo.rxjava.Log;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class IntervalExample {
    public static void main(String[] args) {

        CommonUtils.exampleStart();

        Observable<Long> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(data -> (data + 1) * 100)
                .take(5);
        source.subscribe(Log::it);

        CommonUtils.sleep(1000);

    }
}
