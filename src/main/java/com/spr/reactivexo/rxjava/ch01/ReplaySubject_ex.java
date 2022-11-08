package com.spr.reactivexo.rxjava.ch01;

import io.reactivex.rxjava3.subjects.ReplaySubject;

public class ReplaySubject_ex {
    /**
     ReplaySubject 목적은 뜨거운 옵저베이블을 활용하는 것인데 차거운 옵저베이블 처럼 동작하기 때문에 주의 해야 한다.
     구독자가 새로 생기면 항상 데이터의 처음부터 끝까지 발행하는 것을 보장한다. 마치 테이프로 전체 내용을 녹음해두었다가
     새로운 사람이 들어오면 정해진 음악을 처음부터 들려주는 것과 같다.

     메모리 누수가 발생할 가능성을 염두해야 한다.

     ==> 예제를 보면 두번째 구독자가 구독을 하게 되면 발행되었던 지난 데이터 모두를 받게 된다.
     */
    public static void main(String[] args) {
        ReplaySubject<String> subject = ReplaySubject.create();
        subject.subscribe(data -> System.out.println(("Subscriber 1# => "+ data)));

        int value = 0;

        for(int i=0 ; i < 100 ; i++){
            value++;
            subject.onNext("D " + value);
        }

        subject.subscribe(data -> System.out.println(("Subscriber 2# => "+ data)));
        /**
         * 만약 value 가 엄청난 용량의 데이터라면? 문제임...
         */
        subject.onNext("D " + value+1);
        subject.onComplete();

    }
}
