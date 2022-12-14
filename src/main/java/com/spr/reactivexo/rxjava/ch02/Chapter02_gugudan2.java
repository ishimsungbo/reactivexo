package com.spr.reactivexo.rxjava.ch02;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;

import java.util.Scanner;

public class Chapter02_gugudan2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("구구단 입력 값 : " +  in);
        int dan = Integer.parseInt(in.nextLine());

        Function<Integer, Observable<String>> gugudan = num ->
        Observable.range(1,9).map(row -> num + " * " + row + " = "+ dan * row);

        Observable<String> source = Observable.just(dan).flatMap(gugudan);
        source.subscribe(System.out::println);

    }
}
