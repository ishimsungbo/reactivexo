package com.spr.reactivexo.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.util.Scanner;


@Slf4j
public class Chapter02_gugudan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("구구단 입력 값 : " +  in);
        int dan = Integer.parseInt(in.nextLine());

        Observable<Integer> source = Observable.range(1,9);
        source.subscribe(row -> log.info(dan + " * " + row + " = " + dan * row));

    }
}
