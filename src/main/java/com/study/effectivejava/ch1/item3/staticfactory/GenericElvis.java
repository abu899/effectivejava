package com.study.effectivejava.ch1.item3.staticfactory;

// 코드 3-2 제네릭 싱글톤 팩토리 (24쪽)
public class GenericElvis<T> {

    private static final GenericElvis<Object> INSTANCE = new GenericElvis<>();

    private GenericElvis() { }

    @SuppressWarnings("unchecked")
    public static <E> GenericElvis<E> getInstance() { return (GenericElvis<E>) INSTANCE; }

    public void say(T t) {
        System.out.println(t);
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    public static void main(String[] args) {
        GenericElvis<String> elvis1 = GenericElvis.getInstance();
        GenericElvis<Integer> elvis2 = GenericElvis.getInstance();
        System.out.println(elvis1);
        System.out.println(elvis2);
        elvis1.say("hello");
        elvis2.say(100);
    }

}
