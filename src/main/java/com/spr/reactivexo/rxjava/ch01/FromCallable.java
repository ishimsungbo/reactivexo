package com.spr.reactivexo.rxjava.ch01;

import com.spr.reactivexo.rxjava.CommonUtils;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.Callable;

public class FromCallable {

    /**
     * 비동기 함수
     *
     */

    public static void main(String[] args) {

        //CommonUtils.exampleStart();
        System.out.println("1");
        Callable<String> callable = () ->{
          Thread.sleep(1000);
          return "Hello Callable";
        };

        Observable<String> source = Observable.fromCallable(callable);
        source.subscribe(System.out::println);

        System.out.println("2");
        //CommonUtils.sleep(2000);
        //System.out.println(Thread.currentThread() + "현재 쓰레드 명 ");


    }

}
