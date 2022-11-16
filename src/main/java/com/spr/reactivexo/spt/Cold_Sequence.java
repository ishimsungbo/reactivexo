package com.spr.reactivexo.spt;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/**
 * 차거운<콜드>, 핫<뜨거운> 시퀀스로 나눌수 있다.
 * 아래 예제는 구독을 두번 한다.
 * 각 구독마다 데이터를 새롭게 생성한다.
 *
 * 콜드 - 구독 시점부터 데이터를 받는다.
 * 핫 - 구독 시점 이전 부터 발행된 모든 데이터를 받는다. 메모리 오버풀 문제를 고려해야 한다.
 */

@Slf4j
public class Cold_Sequence {
    public static void main(String[] args) {
        Flux<Integer> seq = Flux.just(1,2,3);

        seq.subscribe(v -> log.info("구독1: {}",v));
        seq.subscribe(v -> log.info("구독2: {}",v));
    }
}
