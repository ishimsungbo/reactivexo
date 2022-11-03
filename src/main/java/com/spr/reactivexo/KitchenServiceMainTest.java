package com.spr.reactivexo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
