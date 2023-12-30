package com.example.ch3.di1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

class Car{
    Engine engine;
    Door door;

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }
}
class Engine{}
class Door{}
class SportsCar extends Car{}
class Truck extends Car{}
public class Main {
    public static void main(String[] args) throws Exception {
        Car car = (Car)getObject("car");   // 다형성 이용
        Engine engine = (Engine)getObject("engine");
        System.out.println("car = "+car);
        System.out.println("engine = "+engine);

    }
    static Object getObject(String key) throws Exception {
//        if(key.equals("car")){
//            return new SportsCar();
//        }
//        else if(key.equals("engine")){
//            return new Engine();
//        }
//        else if(key.equals("door")){
//            return new Door();
//        }
        Properties prop = new Properties();
        Class  clazz = null;    // 지정된 클래스이름에 해당하는 클래스 객체를 얻는다.

        prop.load(new FileReader("config.txt"));
        String className = prop.getProperty(key);   // 지정한 key의 value를 반환
        clazz = Class.forName(className);

        return clazz.newInstance(); // new SportsCar();
    }
    static Car getCar(){
        return new SportsCar();
    }
}
