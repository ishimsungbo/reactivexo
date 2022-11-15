package com.spr.reactivexo;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BaseBeanSetUp {

    @Bean
    HttpTraceRepository traceRepository(){
        return new InMemoryHttpTraceRepository();
    }

}
