package com.spr.reactivexo.rxjava.ch07_backpresser;

import com.spr.reactivexo.rxjava.CommonUtils;
import com.spr.reactivexo.rxjava.Log;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class SampleExample {
    public static void main(String[] args) {
        String[] data = {"1","7","2","3","6"};

        CommonUtils.exampleStart();

        //앞의 4개는 100ms 간격으로 발행
        Observable<String> earlySource = Observable.fromArray(data)
                .take(4)
                .zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS), (a,b) -> a );

        // 마지막 데이터는 200ms 후에 발행.
        Observable<String> lateSource = Observable.just(data[4])
                .zipWith(Observable.timer(300L, TimeUnit.MILLISECONDS), (a,b) -> a );

        // 2개의 Observable 을 결합하고 300ms로 샘플링.
        Observable<String> source = Observable.concat(earlySource, lateSource)
                .sample(300L, TimeUnit.MILLISECONDS,true);

        source.subscribe(Log::it);
        CommonUtils.sleep(1500);

    }
}
