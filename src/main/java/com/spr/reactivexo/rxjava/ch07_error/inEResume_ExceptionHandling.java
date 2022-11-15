package com.spr.reactivexo.rxjava.ch07_error;

import com.spr.reactivexo.rxjava.Log;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class inEResume_ExceptionHandling {

    public static void main(String[] args) {
        String[] salesData = {"100", "200", "A300"};
        Observable<Integer> onParseError = Observable.defer(() -> {
            Log.d("관리자에게 에러 사유를 메일로 알립니다.");
            return Observable.just(-1);
        }).subscribeOn(Schedulers.io());

        Observable<Integer> source = Observable.fromArray(salesData)
                .map(Integer::parseInt)
                .onErrorResumeNext(throwable -> onParseError);

        source.subscribe(data -> {
            if(data < 0){
                Log.e("Wrong Data Found!");
                return;
            }
            Log.i("Sales data : "+ data);
        });
    }
}

/** onErrorResumeNext() 함수
 * onErrorReturn() 과 onErrorReturnItem() 함수는 에러가 발생한 시점에 특정 값으로
 * 대체 하는 것이었.
 * onErrorResumeNext()는 에러 발생시 내가 원하는 Observable 로 대체하는 방법이다.
 * Observable 로 대체한다는 것은 에러 발생시 데이터를 교체하는 것 뿐만 아니라 관리자에게 이메일을
 * 보낸다던가 자원을 해제하는 등의 추가 작업을 할 때 유용하다.
 */