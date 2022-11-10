package com.spr.reactivexo.rxjava.ch05;

import com.spr.reactivexo.rxjava.CommonUtils;
import com.spr.reactivexo.rxjava.Log;
import com.spr.reactivexo.rxjava.OkHttpHelper;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import static com.spr.reactivexo.rxjava.CommonUtils.GITHUB_ROOT;

public class CallbackHeaven2 {

    private static final String FIRST_URL = "https://api.github.com/zen";
    private static final String SECOND_URL = GITHUB_ROOT + "/samples/callback_hell";

    public static void main(String[] args) {

        CommonUtils.exampleStart();

        Observable<String> first = Observable.just(FIRST_URL)
                .subscribeOn(Schedulers.io()) //별도의 io 스케줄을 지정했다.
                .map(OkHttpHelper::get);

        Observable<String> second = Observable.just(SECOND_URL)
                .subscribeOn(Schedulers.io())
                .map(OkHttpHelper::get);

        Observable.zip(first, second, (a,b) -> ("\n>>" + a + "\n>>" + b))
        .subscribe(Log::it);

        CommonUtils.sleep(5000);

    }
}
