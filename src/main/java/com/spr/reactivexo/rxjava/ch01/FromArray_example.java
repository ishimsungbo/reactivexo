package com.spr.reactivexo.rxjava.ch01;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;

public class FromArray_example {
    public static void main(String[] args) {

        /*
        FromArray 는 배열의 데이터를 처리할때 사용
         */
        Integer[] arr = {100,200,300};
        Observable<Integer> s = Observable.fromArray(arr);
        s.subscribe(System.out::println);

    }
}
