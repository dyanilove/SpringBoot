package com.example.ch3.di3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration      // 일반클래스가아니라 설정클래스라는걸 의미
public class AppConfig {
    @Bean
    Car car(){
        return new Car();
    }

    @Bean
    Engine engine(){
        return new Engine();
    }

    @Bean
    Door door(){
        return new Door();
    }
}
