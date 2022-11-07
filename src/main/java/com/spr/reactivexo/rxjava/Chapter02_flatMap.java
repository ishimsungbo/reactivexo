package com.spr.reactivexo.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import lombok.extern.slf4j.Slf4j;


/**
 * 2022-11-07
 * flatmap 함수는 1:1 인 map과 다르게 1: N 이며 결과값이 Observable 이다.. 이해가 어려움.
 * 마블다이어그램 참고가 필요함.
 */
@Slf4j
public class Chapter02_flatMap {
    public static void main(String[] args) {
        Function<String, Observable<String>> getDoubleDiamonds = ball -> Observable.just(ball + "<>", ball + "<>");

        String[] balls = {"1","3","5"};

        Observable<String> source = Observable.fromArray(balls)
                .flatMap(getDoubleDiamonds);

        source.subscribe(log::info);

        System.out.println("=====================================================");

        Observable<String> source02 = Observable.fromArray(balls)
                .flatMap(ball -> Observable.just(ball + "<>", ball + "<>"));
        source02.subscribe(log::info);

    }
}
