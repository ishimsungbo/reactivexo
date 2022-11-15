package com.spr.reactivexo.rxjava.ch07_backpresser;

import com.spr.reactivexo.rxjava.CommonUtils;
import com.spr.reactivexo.rxjava.Log;
import io.reactivex.rxjava3.core.Observable;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * buffer() 함수는 일정시간 동안 데이터를 모아두었다가 한꺼번에 발행한다.
 * 넘치는 데이터 흐름을 제어할 필요가 있을 때 활용할 수 있다.
 */

public class BufferExample01 {
    public static void main(String[] args) {

        String[] data = {"1","2","3","4","5","6","7"};


        CommonUtils.exampleStart();

        // 앞의 3개는 100ms 간격으로 발행한다.
        Observable<String> earlySource = Observable.fromArray(data)
                .take(3)  //3 개만 우선 발행.
                .zipWith(Observable.interval(100L,TimeUnit.MILLISECONDS), (a,b) -> a);

        // 가운데 1개는 300ms 후에 발행
        Observable<String> middleSource = Observable.just(data[3])
                .zipWith(Observable.interval(300L,TimeUnit.MILLISECONDS), (a,b) -> a);

        // 마지막 2개는 100ms 후에 발행
        Observable<String> lastSource = Observable.just(data[4],data[5])
                .zipWith(Observable.interval(100L,TimeUnit.MILLISECONDS), (a,b) -> a);

        // 3개씩 모아서 한꺼번에 발행함.
        Observable<List<String>> source = Observable.concat(earlySource, middleSource, lastSource)
                .buffer(3);  //모아서 지정된 수만큼 발행.

        source.subscribe(Log::it);
        CommonUtils.sleep(1000);

    }
}
