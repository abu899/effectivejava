package com.study.effectivejava.ch4.item21.failfast;

import java.util.ArrayList;
import java.util.List;

public class FailFast {

    public static void main(String[] args) {
        // Immutable
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Mutable
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Fail-fast iterator
        // 이터레이터로 콜렉션을 순회하는 중에 Collection 으로 remove를 사용한다면?
        // ConcurrentModificationException
//        for (Integer number : numbers) {
//            if (number == 3) {
//                numbers.remove(number);
//            }
//        }

        // 이터레이터의 remove 사용하기
        // 이건 안전 -> 이터레이터로 remove
        // Not ConcurrentModificationException
//        for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
//            Integer integer = iterator.next();
//            if(integer == 3) {
//                iterator.remove();
//            }
//        }

//        // 인덱스 사용하기
//        for (int i = 0; i < numbers.size() ; i++) {
//            if (numbers.get(i) == 3) {
//                numbers.remove(numbers.get(i));
//            }
//        }

        // removeIf 사용하기
        // 내부적으로 이터레이터로 remove
        numbers.removeIf(number -> number == 3);
        numbers.forEach(System.out::println);
    }
}
