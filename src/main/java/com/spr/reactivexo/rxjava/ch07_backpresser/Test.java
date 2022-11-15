package com.spr.reactivexo.rxjava.ch07_backpresser;

import com.spr.reactivexo.rxjava.CommonUtils;
import com.spr.reactivexo.rxjava.Log;
import io.reactivex.rxjava3.core.Observable;

public class Test {
    public static void main(String[] args) {
        String[] data = {"1","2","3","4","5","6","7"};


        CommonUtils.exampleStart();

        // 앞의 3개는 100ms 간격으로 발행한다.
        Observable<String> earlySource = Observable.fromArray(data)
                .take(3);

        earlySource.subscribe(Log::it);

        System.out.println(data[3]);

        CommonUtils.sleep(3000);

        System.out.println(50_000_000-1);
    }
}
