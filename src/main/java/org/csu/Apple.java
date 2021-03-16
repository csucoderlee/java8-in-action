package org.csu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Apple {

  private Integer weight;

  private String color;

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public static List<Apple> filterAppleByColor(List<Apple> inventory, String color) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if ("color".equals(apple.getColor())) {
        result.add(apple);
      }
    }
    return result;
  }

  public static List<Apple> filterApplyByWeight(List<Apple> inventory, int weight) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (apple.getWeight() > weight) {
        result.add(apple);
      }
    }
    return result;
  }

  public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (predicate.test(apple)) {
        result.add(apple);
      }
    }
    return result;
  }

  public static <T> List<T> filterFruit(List<T> inventory, FruitPredicate predicate) {
    List<T> result = new ArrayList<>();
    for (T t : inventory) {
      if (predicate.test(t)) {
        result.add(t);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    List<Apple> test = new ArrayList<>();
    Apple apple1 = new Apple();
    apple1.setColor("red");
    apple1.setWeight(160);
    Apple apple2 = new Apple();
    apple2.setColor("green");
    apple2.setWeight(160);
    test.add(apple1);
    test.add(apple2);

    filterApples(test, new AppleWeightPredicate());

    /**
     * 匿名类
     */
    filterApples(test, new ApplePredicate() {
      @Override
      public boolean test(Apple apple) {
        return apple.getWeight() > 150;
      }
    });

    //lambda表达式
    filterApples(test, (Apple apple) -> apple1.getWeight() > 150);


    test.sort(new Comparator<Apple>() {
      @Override
      public int compare(Apple o1, Apple o2) {
        return o1.getWeight().compareTo(o2.getWeight());
      }
    });
  }
}
