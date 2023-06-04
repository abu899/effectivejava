package com.study.effectivejava.ch1.item3.functionalinterface;



import com.study.effectivejava.ch1.item3.methodreference.Person;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DefaultFunctions {

    public static void main(String[] args) {
        // <Input, Output>
        Function<Integer, String> intToString = Object::toString;
        Function<LocalDate, Person> personFunction = Person::new;
        // <Output>, 파라미터 없이 무언가를 return 해주는 함수
        Supplier<Person> personSupplier = Person::new;
        // <Input>, 파라미터를 받아 내부에서 처리하고 끝나는 함수
        Consumer<Integer> integerConsumer = System.out::println;
        // <Input, Boolean>, 특별한 타입의 Function
        Predicate<Person> predicate;
    }
}
