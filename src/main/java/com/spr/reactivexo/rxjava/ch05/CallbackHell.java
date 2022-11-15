package com.spr.reactivexo.rxjava.ch05;

import com.spr.reactivexo.rxjava.Log;
import com.spr.reactivexo.rxjava.OkHttpHelper;
import okhttp3.*;

import java.io.IOException;

import static com.spr.reactivexo.rxjava.CommonUtils.GITHUB_ROOT;

public class CallbackHell {

    private static final String FIRST_URL = "https://api.github.com/zen";
    private static final String SECOND_URL = GITHUB_ROOT + "/samples/callback_hell";

    private final OkHttpClient client = new OkHttpClient();

    private Callback onSuccess = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            e.printStackTrace();
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            Log.i("<<<   두번째 응답  >>>" + FIRST_URL);
            Log.i(response.body().string());
        }
    };

    public void run(){
        Request request = new Request.Builder()
                .url(FIRST_URL)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("<<<   첫번째 응답  >>>" + SECOND_URL);
                Log.i(response.body().string());

                //콜백을 다시 추가.
                Request request = new Request.Builder()
                        .url(SECOND_URL)
                        .build();
                client.newCall(request).enqueue(onSuccess);
            }
        });
    }

    public static void main(String[] args) {
        CallbackHell callbackHell = new CallbackHell();
        callbackHell.run();
    }
}
