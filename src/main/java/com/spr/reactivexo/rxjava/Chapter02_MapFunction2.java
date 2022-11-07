package com.spr.reactivexo.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import lombok.extern.slf4j.Slf4j;


/**
 * 2022-11-07 map 02
 * map 함수는 입력값을 어떤 함수에 넣어서 원하는 값으로 변환하는 함수다.
 */
@Slf4j
public class Chapter02_MapFunction2 {
    public static void main(String[] args) {



        Function<String, Integer> ballToIndex = ball -> {
          switch (ball){
              case "RED" : return 1;
              case "YELLOW" : return 2;
              case "GREEN" : return 3;
              case "BLUE" : return 5;
              default:  return -1;
          }
        };

        String[] balls = {"RED", "YELLOW" , "GREEN", "BLUE"};
        Observable<Integer> source = Observable.fromArray(balls)
                .map(ballToIndex);   // 변환하는 함수

        source.subscribe(System.out::println);

    }
}
