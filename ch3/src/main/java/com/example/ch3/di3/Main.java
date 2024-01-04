package com.example.ch3.di3;

import com.example.ch3.di3.AppConfig;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

@Component
class Car{
//    @Resource(name="engine")    // byName으로 빈 검색
//    @Resource(name="superEngine")
    @Autowired
    @Qualifier("superEngine")
    Engine engine;
    @Resource(name="door")
    Door door;

//    public Car(){}
//
//    @Autowired
//    public Car(Engine[] engine, Door door) {
//        this.engine = engine;
//        this.door = door;
//    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" +engine +
                ", door=" + door +
                '}';
    }
}
class Engine{}

@Component
class SuperEngine extends Engine{}
@Component
class TubroEngine extends Engine{}
@Component
class Door{}
public class Main {
    public static void main(String[] args) {
        // AC를 생성 -  AC의 설정파일은 Appconfig.class 자바설정
        ApplicationContext  ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Car car = (Car)ac.getBean("car");
        System.out.println("car = " + car);
//        Car car = ac.getBean("car",Car.class);  // 위 코드와 동일
//        Engine engine = ac.getBean(Engine.class);
//        Engine engine2 = ac.getBean(Engine.class);
//        Engine engine3 = ac.getBean(Engine.class);
//        System.out.println("car = " + car);
//        System.out.println("engine = " + engine);
//        System.out.println("engine2 = " + engine2);
//        System.out.println("engine3 = " + engine3); // 주소값 같음.. 싱글톤이기때문.. 다르게 할라면 @Scope("prototype")이라고 붙여줘야함.. appconfig에
//
//        SysInfo info = ac.getBean(SysInfo.class);
//        System.out.println("info = " + info);
//        System.out.println("ac.getBeanDefinitionCount() = " + ac.getBeanDefinitionCount());
//        System.out.println("ac.getBeanDefinitionNames() = " + Arrays.toString(ac.getBeanDefinitionNames()));
//        System.out.println("ac.containsBeanDefinition(\"engine\") = " + ac.containsBeanDefinition("engine"));
//        System.out.println("ac.isSingleton(\"car\") = " + ac.isSingleton("car"));
//        System.out.println("ac.isPrototype(\"engine\") = " + ac.isPrototype("engine"));


    }
}
