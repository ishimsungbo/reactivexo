package com.spr.reactivexo.rxjava;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpHelper {
	private static OkHttpClient client = new OkHttpClient();
	public static String ERROR = "ERROR";

	public static String getUserFunction(String url) throws IOException {
		System.out.println("===> 내가 만든 함수  실행1 : " + url);
		return url;
	}

	public static void print(String url) throws IOException {
		System.out.println("===> 내가 만든 함수  실행2 : " + url);
	}

	public static String get(String url) throws IOException { 
		Request request = new Request.Builder()
		        .url(url)
		        .build();
		try {
			Response res = client.newCall(request).execute();
			return res.body().string();
		} catch (IOException e) {
			Log.e(e.getMessage());
			throw e;
		} 
	}

	public static String getT(String url) throws IOException { 
		Request request = new Request.Builder()
		        .url(url)
		        .build();
		try {
			Response res = client.newCall(request).execute();
			return res.body().string();
		} catch (IOException e) {
			Log.et(e.getMessage());
			throw e;
		} 
	}
	
	public static String getWithLog(String url) throws IOException { 
		Log.d("OkHttp call URL = " + url);
		return get(url);
	}	
}
