package com.spr.reactivexo.rxjava.ch07_backpresser;

import com.spr.reactivexo.rxjava.CommonUtils;
import com.spr.reactivexo.rxjava.Log;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class BackPressure01 {
    public static void main(String[] args) {

        CommonUtils.exampleStart();

        PublishSubject<Integer> subject = PublishSubject.create();
        subject.observeOn(Schedulers.computation())
                .subscribe(data -> {
            CommonUtils.sleep(1000);
                    Log.it(data);
        } , err -> Log.e(err.toString()));

        // 뜨거운 Observable 로 50,000,000 개의 데이터를 연속으로 발행함.
        for(int i =0 ; i < 50_000_000 ; i++){
            subject.onNext(i);
            //System.out.println("여기?");
        }

        subject.onComplete();

    }
}
