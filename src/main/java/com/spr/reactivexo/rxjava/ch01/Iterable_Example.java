package com.spr.reactivexo.rxjava.ch01;

import com.spr.reactivexo.rxjava.Order;
import io.reactivex.rxjava3.core.Observable;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Iterable_Example {
    public static void main(String[] args) {

        /**
         * Iterable 인터페이스는 이터레이터 패턴을 구현한 것으로 다음에 어떤 데이터가 있는지와
         * 그 값을 얻어오는 것만 관여할 뿐, 특정 데이터 타입에 의존하지 않는 장점이 있다.
         * 자바의 많은 컬렉션 클래스가 이 인터페이스를 구현한다.
         */
        System.out.println("=======================================================");
        System.out.println("예제 1");
        System.out.println("=======================================================");
        List<String> names = new ArrayList<>();
        names.add("심청");
        names.add("홍길동");
        names.add("자두");

        Observable<String> source = Observable.fromIterable(names);
        source.subscribe(System.out::println);

        System.out.println("=======================================================");
        System.out.println("예제 2");
        System.out.println("=======================================================");

        Set<String> cities = new HashSet<>();
        cities.add("서울");
        cities.add("런던");
        cities.add("파리");

        Observable<String> s = Observable.fromIterable(cities);
        s.subscribe(System.out::println);

        System.out.println("=======================================================");
        System.out.println("예제 3");
        System.out.println("=======================================================");

        BlockingQueue<Order> orderQueue = new ArrayBlockingQueue<>(100);
        orderQueue.add(new Order("O-1"));
        orderQueue.add(new Order("O-2"));
        orderQueue.add(new Order("O-3"));

        Observable<Order> o1 = Observable.fromIterable(orderQueue);
        o1.subscribe(System.out::println);

    }
}
