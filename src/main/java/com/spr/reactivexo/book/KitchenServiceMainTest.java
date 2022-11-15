package com.spr.reactivexo.book;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class KitchenServiceMainTest {



    public static void main(String[] args) {
        System.out.println("테스트 시작");
        //KitchenService kitchenService = new KitchenService();
        Flux<Dish> dishFlux = new KitchenService().getDishes();
        dishFlux.doOnNext(System.out::println)
                .subscribe(i->
                System.out.println("모지? "+i));

        System.out.println("테스트 종료");
    }
}
