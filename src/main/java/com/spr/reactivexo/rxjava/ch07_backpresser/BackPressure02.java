package com.spr.reactivexo.rxjava.ch07_backpresser;

import com.spr.reactivexo.rxjava.CommonUtils;
import com.spr.reactivexo.rxjava.Log;
import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Flowable.range 함수를 활용 동일한 개수의 데이터를발행
 * 128개의 버퍼를 생성한 후 버퍼의 넘침(overflow)이 발생하면 버퍼의 가장 오래된 데이터를 버리도록
 * 전략을 설정한다.
 * onBackpressureBuffer() 함수가 버퍼를 만들어 쌓아 두었다가 처리하는 방식
 * onBackpressureDrop() 함수는 버퍼가 가득 찼을 때 이후 데이터를 그냥 무시한다.
 */

public class BackPressure02 {

    public static void main(String[] args) {

        CommonUtils.exampleStart();

        Flowable.range(1, 50_000_000)
                .onBackpressureBuffer(128, () -> {} , BackpressureOverflowStrategy.DROP_OLDEST)
                .observeOn(Schedulers.computation())
                .subscribe(data -> {
                    CommonUtils.sleep(100);
                    Log.it(data);
                }, e -> Log.e(e.toString()));

    }
}
