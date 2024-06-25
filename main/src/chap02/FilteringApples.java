package chap02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {

  public static void main(String[] args) {
    List<Apple> inventory = Arrays.asList(
        new Apple(80, Color.GREEN),
        new Apple(155, Color.GREEN),
        new Apple(120, Color.RED)
    );

    List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());
    System.out.println("redAndHeavyApples = " + redAndHeavyApples);

    /**
     * 4. 익명 클래스 사용
     */
    List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
      @Override
      public boolean test(Apple apple) {
        return apple.getColor() == Color.RED;
      }
    });
    System.out.println(redApples);

    /**
     * 5. 람다 표현식 사용
     */
    List<Apple> result = filterApples(inventory, (Apple apple) -> apple.getColor() == Color.RED);
    System.out.println(result);

    /**
     * 6. 리스트 형식으로 추상회
     */
    List<Apple> redApple = filter(inventory, (Apple apple) -> apple.getColor() == Color.RED);

  }

  /**
   * 1. 녹색 사과 필터링
   */
  public static List<Apple> filterGreenApples(List<Apple> inventory) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (apple.getColor().equals(Color.GREEN)) {
        result.add(apple);
      }
    }
    return result;
  }

  /**
   * 2. 색을 파라미터화
   */
  public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (apple.getColor().equals(color)) {
        result.add(apple);
      }
    }
    return result;
  }

  /**
   * 3. 추상적 조건으로 필터링
   */
  public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (p.test(apple)) {
        result.add(apple);
      }
    }
    return result;
  }

  /**
   * 6. 리스트 형식으로 추상화
   */
  public interface Predicate<T> {
    boolean test(T t);
  }
  public static <T> List<T> filter(List<T> list, Predicate<T> p) {  //형식 파라미터 T 사용
    List<T> result = new ArrayList<>();
    for (T e : list) {
      if (p.test(e)) {
        result.add(e);
      }
    }
    return result;
  }

  public interface ApplePredicate {
    boolean test(Apple apple);
  }

  static class AppleHeavyWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
      return apple.getWeight() > 150;
    }
  }
  static class AppleGreenColorPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
      return apple.getColor() == Color.GREEN;
    }
  }
  static class AppleRedAndHeavyPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
      return apple.getColor() == Color.RED && apple.getWeight() > 150;
    }
  }

  enum Color {
    RED, GREEN
  }

  public static class Apple {
    private int weight = 0;
    private Color color;

    public Apple(int weight, Color color) {
      this.weight = weight;
      this.color = color;
    }

    public int getWeight() {
      return weight;
    }

    public void setWeight(int weight) {
      this.weight = weight;
    }

    public Color getColor() {
      return color;
    }

    public void setColor(Color color) {
      this.color = color;
    }

    @Override
    public String toString() {
      return String.format("Apple{color=%s, weight=%d}", color, weight);
    }
  }

}

