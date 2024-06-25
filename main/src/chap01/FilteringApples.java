package chap01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {

  public static void main(String[] args) {
    List<Apple> inventory = Arrays.asList(
        new Apple(80, "green"),
        new Apple(155, "green"),
        new Apple(120, "red")
    );

    List<Apple> greenApples1 = filterApples(inventory, FilteringApples::isGreenApple);
    System.out.println("greenApples1 = " + greenApples1);

    List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
    System.out.println("greenApples2 = " + greenApples2);


  }

  /**
   * 자바 8 이전
   * 사과 색깔이 초록색인 것만 필터링해 반환
   */
  public static List<Apple> filterGreenApples(List<Apple> inventory) {
    List<Apple> result = new ArrayList<>();

    for (Apple apple : inventory) {
      if ("green".equals(apple.getColor())) {
        result.add(apple);
      }
    }
    return result;
  }

  /**
   * 자바 8 이후 사과 색깔이 초록색인 것만 필터링해 반환
   */
  public static boolean isGreenApple(Apple apple) {
    return "green".equals(apple.getColor());
  }

  public interface Predicate<T>{
    boolean test(T t);

  }

  static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (p.test(apple)) {
        result.add(apple);
      }
    }
    return result;
  }

  public static class Apple {
    private int weight = 0;
    private String color;

    public Apple(int weight, String color) {
      this.weight = weight;
      this.color = color;
    }

    public int getWeight() {
      return weight;
    }

    public void setWeight(int weight) {
      this.weight = weight;
    }

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }

    @Override
    public String toString() {
      return String.format("Apple{color=%s, weight=%d}", color, weight);
    }
  }

}
