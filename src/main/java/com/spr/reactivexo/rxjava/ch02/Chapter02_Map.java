package com.spr.reactivexo.rxjava.ch02;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import lombok.extern.slf4j.Slf4j;


/**
 * 2022-11-07
 * map 함수는 입력값을 어떤 함수에 넣어서 원하는 값으로 변환하는 함수다.
 */
@Slf4j
public class Chapter02_Map {
    public static void main(String[] args) {
        String[] balls = {"1","2","3","4"};
        Observable<String> source = Observable.fromArray(balls)
                .map(ball -> ball + "<>");

        source.subscribe(log::info);

        Function<String, String> getDiamond = ball -> ball+ "<>";
    }
}
