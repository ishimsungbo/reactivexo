package com.spr.reactivexo.rxjava.ch01;

import io.reactivex.rxjava3.subjects.AsyncSubject;

public class AsyncSubjectExample {

    /**
     * Subject 클래스는 차운 옵저버블을 뜨거운 옵저버블로 바꾸어 준다.
     *  AsyncSubject 클래스는 옵저버블에서 발행한 마지막 데이터를 얻어올 수 있는 Subject
     *  클래스다. 완료되기 전까지 마지막 데이터에만 관심이 있고 이전 데이터는 무시한다.
     *  마블참고
     */

    public static void main(String[] args) {
        AsyncSubject<String> subject = AsyncSubject.create();
        subject.subscribe(data-> System.out.println("Subscriber #1 => : " + data));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(data-> System.out.println("Subscriber #2 => : " + data));
        subject.onNext("5");
        subject.onComplete();
    }
}
