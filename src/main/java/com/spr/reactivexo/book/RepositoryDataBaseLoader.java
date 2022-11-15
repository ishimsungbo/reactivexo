package com.spr.reactivexo.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

//@Component
public class RepositoryDataBaseLoader {

    /**
     * CommandLineRunner
     * 어플리케이션이 시작된 후에 자동으로 실행되는 특수한 스프링 부트 컴포넌트로서 run() 메서드
     * 하나만 갖고 있는 함수형 인터페이스다. 어플리케이션에서 사용되는 모든 컴포넌트가 등록되고
     * 활성화된 이후에 run() 메소드가 자동으로 실행되는 것이 보장된다.
     */
  /*
    @Bean
    CommandLineRunner initialize(BlockingItemRepository repository){
        return args -> {
          repository.save(new Item("All alarm clock",19.99));
          repository.save(new Item("Smurf TV try",24.99));
        };
    }

    */
    /*
    @Bean
    CommandLineRunner initialize(MongoOperations mongo) {
        return args -> {
            mongo.save(new Item("Alf alarm clock", 19.99));
            mongo.save(new Item("Smurf TV tray", 24.99));
        };
    }
     */

}

