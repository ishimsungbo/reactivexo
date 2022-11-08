package com.spr.reactivexo.rxjava.ch01;

import io.reactivex.rxjava3.subjects.PublishSubject;

public class PublishSubject_Ex {

    /**
     * 기본값을 발행하지도 않고 무조건 구독을 한 순간 부터 값을 받는다.
     *
     */

    public static void main(String[] args) {
        PublishSubject<String> subject = PublishSubject.create();

        subject.subscribe(data -> { System.out.println("PublishSubject Subscribe 1# : " + data); });

        subject.onNext("100");
        subject.onNext("200");
        subject.onNext("300");

        subject.subscribe(data -> { System.out.println("PublishSubject Subscribe 2# : " + data); }); // 400부터 시작된다.

        subject.onNext("400");
        subject.onNext("500");
    }

}
