package com.spr.reactivexo.rxjava.ch01;

import com.spr.reactivexo.rxjava.CommonUtils;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import sun.nio.cs.ext.IBM037;

import java.util.concurrent.TimeUnit;

public class ConnectableObservable_Example {

    /**
     * 오로지  connect 함수를 호출해야 그때까지 구독했던 구독자 모두에게 데이터를 발행한다.
     * connect 함수를 호출한 이후에 구독한 구독자에게는 구독 이후에 발생한 데이터 5 부터 발행한다.
     *
     */

    public static void main(String[] args) {

        String[] dt = {"1","2","3"};

        Observable<String> balls = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(i-> dt[i])
                .take(dt.length);

        ConnectableObservable<String> source = balls.publish();
        source.subscribe(data -> System.out.println("subscriber Data 1# : " + data));
        source.subscribe(data -> System.out.println("subscriber Data 2# : " + data));
        source.connect();

        CommonUtils.sleep(250);
        source.subscribe(data -> System.out.println("subscriber Data 3# : " + data));
        CommonUtils.sleep(100);

    }

}
