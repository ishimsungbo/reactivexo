package com.spr.reactivexo.rxjava.ch04;

import com.spr.reactivexo.rxjava.CommonUtils;
import com.spr.reactivexo.rxjava.Log;
import com.spr.reactivexo.rxjava.OkHttpHelper;
import io.reactivex.rxjava3.core.Observable;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;


public class RepeatHttp_Example {

    public static void main(String[] args) {

        CommonUtils.exampleStart();
        String serverUrl = "https://api.github.com/zen";

        // 2초 간격으로 서버에 ping 보내기
        Observable.timer(2, TimeUnit.SECONDS)
                .map(val -> serverUrl)
                //.map(OkHttpHelper::getUserFunction)
                //.doOnNext(OkHttpHelper::print) //중간결과 확인용 함수
                .map(OkHttpHelper::get)
                .timeInterval(TimeUnit.MILLISECONDS)
                .repeat()
                .subscribe(res -> Log.it("Ping Result : " + res));


        CommonUtils.sleep(10000);

    }
}
