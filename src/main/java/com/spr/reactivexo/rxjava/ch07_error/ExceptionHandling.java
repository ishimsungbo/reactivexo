package com.spr.reactivexo.rxjava.ch07_error;

import com.spr.reactivexo.rxjava.Log;
import io.reactivex.rxjava3.core.Observable;

public class ExceptionHandling {

    /**
     * 앞의 3개의 데이터가 정상적으로 발행되고 마지막 데이터에서 어떤 에러가 발생하는 경우
     * onErrorReturn() 함수는 인자로 넘겼던 기본값을 대신 발행하고 onComplete 이벤트가 발생합니다.
     * onError 이벤트는 발생하지 않습니다.
     *
     */

    public static void main(String[] args) {
        String[] grades = {"70","88","$100","93","83"}; //$100 이 에러 데이터

        Observable<Integer> source = Observable.fromArray(grades)
                .map(data -> Integer.parseInt(data))
                .onErrorReturn(e -> {
                   if(e instanceof NumberFormatException){
                       e.printStackTrace();
                   }
                   return -1;
                });

        source.subscribe(data ->{
            if(data < 0){
                Log.e("Wrong Data found!!");
            }
            Log.i("Grade is " + data);
        });
    }

}
