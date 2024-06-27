package chap04;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamBasic {
  public static void main(String[] args) {
    // 자바 7
    getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

    //자바 8
    getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
  }

  /**
   * 저칼로리의 요리명을 반환하고, 칼로리를 기준으로 요리 정렬
   */
  public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
    List<Dish> lowCaloricDishes = new ArrayList<>();
    for (Dish d : dishes) {
      if (d.getCalories() < 400) {
        lowCaloricDishes.add(d);
      }
    }
    List<String> lowCaloricDishesNames = new ArrayList<>();
    Collections.sort(lowCaloricDishes, new Comparator<Dish>() { //익명 클래스로 요리 정렬
      @Override
      public int compare(Dish d1, Dish d2) {
        return Integer.compare(d1.getCalories(), d2.getCalories());
      }
    });
    for (Dish d : lowCaloricDishes) {
      lowCaloricDishesNames.add(d.getName()); // 정렬된 리스트를 처리하면서 요리 이름 선택
    }
    return lowCaloricDishesNames;
  }

  public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
    return dishes.stream()
        .filter(d -> d.getCalories() < 400) // 400 칼로리 이하의 요리 선택
        .sorted(comparing(Dish::getCalories)) // 칼로리로 요리 정렬
        .map(Dish::getName) // 요리명 추출
        .collect(toList()); // 모딘 요리명을 리스트에 저장
  }
}
