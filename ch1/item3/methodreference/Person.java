package com.study.effectivejava.ch1.item3.methodreference;

import org.w3c.dom.CDATASection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    LocalDate birthday;

    public Person() {

    }

    public Person(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }
    public int compareByAgeInstance(Person b) {
        return this.birthday.compareTo(b.birthday);
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(LocalDate.of(1982, 7, 15)));
        people.add(new Person(LocalDate.of(2011, 3, 2)));
        people.add(new Person(LocalDate.of(2013, 1, 28)));

        // 익명 내부 클래스
        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return a.birthday.compareTo(b.birthday);
            }
        });

        // 람다식
        people.sort((p1, p2) -> Person.compareByAge(p1, p2));

        // method reference
        people.sort(Person::compareByAge);

        // 임의 객체의 인스턴스 메서드 레퍼런스
        // Comparator 가 두 개의 인자를 받지만, 첫 번쨰 인자는 자기자신으로 넘기기에 호환 가능
        people.sort(Person::compareByAgeInstance);

        // 생성자 레퍼런스
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(1989, 2, 3));
        dates.add(LocalDate.of(1989, 2, 4));
        List<Person> ppl = dates.stream().map(Person::new).collect(Collectors.toList());
    }

}
