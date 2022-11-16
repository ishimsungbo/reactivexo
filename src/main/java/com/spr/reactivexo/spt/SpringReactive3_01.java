package com.spr.reactivexo.spt;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import reactor.core.publisher.Mono;

public class SpringReactive3_01 {

    public static void main(String[] args) throws InterruptedException {

        final Mono<String> mono = Mono.just("hello");

        Thread t = new Thread(() -> {
            mono.map(msg -> msg +" : Thread")
                    .subscribe(v -> System.out.println(v +" : "+ Thread.currentThread().getName())
                    );
        });

        t.start();
        t.join();

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("저는 두번째 시작" + Thread.currentThread().getName());

                for(int i = 0; i < 10 ;i++){
                    try {
                        Thread.sleep(2000);
                        System.out.println("투번째 쓰레드 하는 중 " + i);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("저는 두번째 종료" + Thread.currentThread().getName());
            }
        });

        a.start();
        a.join();
        System.out.println("메인쓰레드 종료");

    }
}
