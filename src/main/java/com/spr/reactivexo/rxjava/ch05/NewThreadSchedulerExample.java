package com.spr.reactivexo.rxjava.ch05;

import com.spr.reactivexo.rxjava.CommonUtils;
import com.spr.reactivexo.rxjava.Log;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NewThreadSchedulerExample {

    /**
     * subscribeOn, observeOn
     * 두 함수가 어떤 기능을 수행하는지을 정확히 알아야 한다.
     */

    public static void main(String[] args) {

        String[] params = {"1","3","5"};

        Observable.fromArray(params)
                .doOnNext(data -> Log.i("Original data : " + data))
                .map(data -> "<<" + data + ">>")
                .subscribeOn(Schedulers.newThread())
                //.doOnNext(data -> Log.i("222 Original data : " + data))
                //.subscribeOn(Schedulers.newThread())
                .subscribe(Log::i);
        CommonUtils.sleep(500);

        Observable.fromArray(params)
                .doOnNext(data -> Log.i("Original data : " + data))
                .map(data -> "##" + data + "##")
                .subscribeOn(Schedulers.newThread())
                .subscribe(Log::i);
        CommonUtils.sleep(500);

        /**
         * CommonUtils.sleep(500) 을 주지 않으면 main  쓰레드가 끝나버린다. 서로 다른 쓰레드가 돌기에 대기.
         */

    }
}
