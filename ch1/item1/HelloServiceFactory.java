package com.study.effectivejava.ch1.item1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.ServiceLoader;

public class HelloServiceFactory {

    public static HelloService of(String lang) {
        if (lang.equals("ko")) {
            return new KoreanHelloService();
        } else {
            return new EnglishHelloService();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

//        HelloService helloService = HelloServiceFactory.of("ko");
        HelloService helloService = HelloService.of("ko");
        helloService.hello();

        // ChineseHelloService 에 의존적이지 않음
        // 어떤 구현체가 올지 모름
        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
        Optional<HelloService> helloServiceOptional = loader.findFirst();
        helloServiceOptional.ifPresent(h -> {
            System.out.println(h.hello());
        });

        // ChineseHelloService 에 의존적
        HelloService helloService2 = new ChineseHelloService();
        System.out.println(helloService.hello());

//        Class<?> aClass = Class.forName("me.whiteship.hello.ChineseHelloService");
//        Constructor<?> constructor = aClass.getConstructor();
//        HelloService helloService = (HelloService) constructor.newInstance();
//        System.out.println(helloService.hello());
    }

}
