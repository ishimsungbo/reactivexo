package com.spr.reactivexo.rxjava.ch07_backpresser;

import com.spr.reactivexo.rxjava.CommonUtils;
import com.spr.reactivexo.rxjava.Log;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * onBackpressureDrop() 은 128 기본버퍼 만큼 받고 나머지는 버린다.
 * 자기가 받을 수 있는 만큼만 받는다.
 */

public class BackPressure03 {

    public static void main(String[] args) {
        CommonUtils.exampleStart();

        Flowable.range(1, 50_000_000)
                .onBackpressureDrop()
                .observeOn(Schedulers.computation())
                .subscribe(data -> {
                    CommonUtils.sleep(100);
                    Log.it(data);
                },e -> e.toString());

        CommonUtils.sleep(20_000);
    }

}
