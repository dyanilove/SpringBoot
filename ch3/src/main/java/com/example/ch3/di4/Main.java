package com.example.ch3.di4;

import com.example.ch3.Ch3Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.Arrays;

//@SpringBootApplication    // 은 아래의 3개 애너테이션을 붙인것과 동일
@SpringBootConfiguration    // @Configuration하고 동일
//@EnableAutoConfiguration
@ComponentScan
public class Main {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(Ch3Application.class, args);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        Arrays.sort(beanDefinitionNames);   // 빈 목록이 담긴 배열을 정렬
        Arrays.stream(beanDefinitionNames)  // 배열을 스트림을 변환
                .forEach(System.out::println);  // 스트림의 요소를 하나씩 꺼내서 출력
    }

    @Bean
    MyBean myBean(){return new MyBean();}

}

class MyBean{}