package com.study.effectivejava.ch1.item2.javabeans;

// 코드 2-2 자바빈즈 패턴 - 일관성이 깨지고, 불변으로 만들 수 없다. (16쪽)
public class NutritionFacts {
    // 필드 (기본값이 있다면) 기본값으로 초기화된다.
    private int servingSize = -1; // 필수; 기본값 없음
    private int servings = -1; // 필수; 기본값 없음
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;
    private boolean healthy;

    public NutritionFacts() {
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public static void main(String[] args) {
        // 객체 생성이 간단해지나, 필수적인 값들의 셋팅이 안되어있음
        NutritionFacts cocaCola = new NutritionFacts();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        // 여기까지 만들어져야 필수적인 요소가 포함된 완전한 객체가 되지만
        // 생성자나 setter 만을 보고서는 어디까지 셋팅을 해야되는지 알 수 없음!!

        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
    }
}
