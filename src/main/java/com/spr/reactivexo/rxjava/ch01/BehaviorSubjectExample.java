package com.spr.reactivexo.rxjava.ch01;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class BehaviorSubjectExample {
    public static void main(String[] args) {
        /**
         * BehaviorSubject 구독자가 구독을 하면 가장 최근 값 혹은 기본값을 넘겨주는 클래스 입니다.
         * 예를 들어 온도 센서에서 값을 받아온다면 가장 최근의 온도 값을 받아오는 동작을 구현할 수 있습니다.
         * 또한 온도를 처음 얻을 때는 초깃값을 반환하기도 한다.
         */
        BehaviorSubject<String> subject = BehaviorSubject.createDefault("6");
        subject.subscribe(d -> System.out.println("subscriber 1# : " + d)); //처음 구독자는 기본값을 받고 이후 받는다.
        subject.onNext("1");
        subject.onNext("3");

        subject.onNext("4");
        subject.subscribe(d -> System.out.println("subscriber 2# : " + d)); //두번째 구독자는 마지막 발행한 것 이후에 받는다.
        subject.onNext("5");
        subject.onComplete();

    }
}
