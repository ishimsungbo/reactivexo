package com.spr.reactivexo.book;

import lombok.extern.slf4j.Slf4j;
import java.net.URI;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.ResponseEntity;

/**
 * API 조회, 생성의 예
 * findAll 모든 Item 객체를 받아서 아무런 필터링이나 가공 없이 그대로 반환하는 간단한 예이다. 사실상
 * 데이터가 저장된 몽고디비로의 연결 통로 역할만 한다. 가장 먼저 눈여겨볼 것은 메소드가 반환하는 값이
 * 리액터 타입인 Flux 라는 점이다.
 */

@Slf4j
@RestController
public class ApiItemController {

    private final ItemRepository repository;

    public ApiItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/items")
    Flux<Item> findAll(){
        log.info("조회합니다. 컨트롤러는 단순한 통로다.");
        return this.repository.findAll();
    }

    @GetMapping("/api/item/{id}")
    Mono<Item> findOne(@PathVariable String id){
        return this.repository.findById(id);
    }

    @PostMapping("/api/items")
    Mono<ResponseEntity<?>> addNewItem(@RequestBody Mono<Item> item){ //

        return item.flatMap(s-> this.repository.save(s)) //
                .map(savedItem -> ResponseEntity //
                .created(URI.create("/api/items" + //
                        savedItem.getId()))
                        .body(savedItem));
    }


    @PutMapping("/api/items/{id}")
    Mono<ResponseEntity<?>> updateItem(
            @RequestBody Mono<Item> item,
            @PathVariable String id){

        return item.map(content -> new Item(id, content.getName(), content.getDescription(),
                content.getPrice())).flatMap(this.repository::save)
                .map(ResponseEntity::ok);
    }
}
