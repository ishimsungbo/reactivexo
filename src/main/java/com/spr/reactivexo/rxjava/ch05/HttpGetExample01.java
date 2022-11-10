package com.spr.reactivexo.rxjava.ch05;

import com.spr.reactivexo.rxjava.Log;
import okhttp3.*;

import java.io.IOException;

/**
 * 콜백지옥에서 어떻게 RX java 가 벗어나는지 예제
 */
public class HttpGetExample01 {

    private static final OkHttpClient client = new OkHttpClient();

    private static final String URL_README =
            "https://raw.githubusercontent.com/yudong80/reactivejava/master/README.md";

    public static void main(String[] args) {

        Request request = new Request.Builder()
                .url(URL_README)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(response.body().string());
            }
        });


    }

}
