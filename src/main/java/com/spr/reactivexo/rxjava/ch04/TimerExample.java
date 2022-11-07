package com.spr.reactivexo.rxjava.ch04;

import com.spr.reactivexo.rxjava.CommonUtils;
import com.spr.reactivexo.rxjava.Log;
import io.reactivex.rxjava3.core.Observable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimerExample {

    public static void main(String[] args) {
        CommonUtils.exampleStart();

        Observable<String> source = Observable.timer(500L, TimeUnit.MILLISECONDS)
                .map(notUsed -> {
                   return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                   .format(new Date());
                });
        source.subscribe(Log::it);
        System.out.println("몇 초 후?" + 2000);
        CommonUtils.sleep(2000);
        System.out.println(Thread.currentThread() + "현재 쓰레드 명 ");
    }
}
