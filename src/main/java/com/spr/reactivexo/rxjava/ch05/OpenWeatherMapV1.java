package com.spr.reactivexo.rxjava.ch05;

// openweather 사이트 가입하고 api 키를 얻음. api 키 얻고 한참 후에 가능
// https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=600d9dad880bc66a378e79da3ed15a43


import com.spr.reactivexo.rxjava.CommonUtils;
import com.spr.reactivexo.rxjava.Log;
import com.spr.reactivexo.rxjava.OkHttpHelper;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OpenWeatherMapV1 {

        /**
         * IO 스케줄러
         * IO 스케줄러는 계산 스케줄러와는 다르게 네트워크상의 요청을 처리하거나 각종 입, 출력 작업을 실행하기 위한
         * 스케줄러다. 계산 스케줄러는 cpu 개수만큼 스레드를 생성하지만 IO 스케줄러는 필요할 때마다 스레드를 계속 생성
         * 한다. 입, 출력 작업은 비동기로 실행되지만 결과를 얻기까지 대기 시간이 길다.
         * 
         * 계산 스케줄러 : 일반적인 계산작업
         * IO 스케줄러: 네트워크상의 요청, 파일 입출력, DB쿼리등
         */

        private static final String URL = "https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=";

        public void run(){
                /**
                Observable<String> source = Observable.just(URL + "600d9dad880bc66a378e79da3ed15a43")
                        .map(OkHttpHelper::getWithLog)
                        .subscribeOn(Schedulers.io());

                // 어떻게 하면 한 번만 호출하게 만들 수 있을까?
                Observable<String> temperature = source.map(this::parseTemperature);
                Observable<String> city = source.map(this::parseCityName);
                Observable<String> country = source.map(this::parseCountry);

                CommonUtils.exampleStart();

                Observable.concat(temperature, city, country)
                        .observeOn(Schedulers.newThread())
                        .subscribe(Log::it);
                CommonUtils.sleep(8000);
                 **/
                CommonUtils.exampleStart();

                Observable<String> source = Observable.just(URL + "600d9dad880bc66a378e79da3ed15a43")
                        .map(OkHttpHelper::getWithLog)
                        .subscribeOn(Schedulers.io())
                        .share()
                        .observeOn(Schedulers.newThread());


                        source.map(this::parseTemperature).subscribe(Log::it);
                        source.map(this::parseCityName).subscribe(Log::it);
                        source.map(this::parseCountry).subscribe(Log::it);


                CommonUtils.sleep(5000);

        }

        private String parseTemperature(String json){
                return parse(json, "\"temp\":[0-9]*.[0-9]*");
        }

        private String parseCityName(String json){
                return parse(json, "\"name\":\"[a-zA-Z]*\"");
        }

        private String parseCountry(String json){
                return parse(json,"\"country\":\"[a-zA-Z]*\"");
        }

        private String parse(String json, String regex){
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(json);
                if(matcher.find()){
                        return matcher.group();
                }
                return "N/A";
        }

        public static void main(String[] args) {
                OpenWeatherMapV1 demo = new OpenWeatherMapV1();
                demo.run();
        }
}
