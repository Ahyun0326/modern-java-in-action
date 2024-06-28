package chap05;

import static chap04.Dish.*;
import static java.util.stream.Collectors.toList;

import chap04.Dish;
import java.util.Arrays;
import java.util.List;

public class Filtering {

  public static void main(String[] args) {
    // 프리디케이트로 거름
    System.out.println("Filtering with a predicate");
    List<Dish> vegetarianMenu = menu.stream()
        .filter(Dish::isVegetarian)
        .collect(toList());
    vegetarianMenu.forEach(System.out::println);

    // 고유 요소로 거름
    System.out.println("Filtering unique elements");
    List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
    numbers.stream()
        .filter(i -> i % 2 == 0)
        .distinct()
        .forEach(System.out::println);

    // 스트림 슬라이스
    // 칼로리 값을 기준으로 리스트를 오름차순 정렬
    List<Dish> specialMenu = Arrays.asList(
        new Dish("season fruit", true, 120, Dish.Type.OTHER),
        new Dish("prawns", false, 300, Dish.Type.FISH),
        new Dish("rice", true, 350, Dish.Type.OTHER),
        new Dish("chicken", false, 400, Dish.Type.MEAT),
        new Dish("french fries", true, 530, Dish.Type.OTHER));
    System.out.println("Filtered sorted menu:");
    List<Dish> filteredMenu = specialMenu.stream()
        .filter(d -> d.getCalories() < 320)
        .collect(toList());
    filteredMenu.forEach(System.out::println);

    System.out.println("Sorted menu sliced with takeWhile():");
    List<Dish> slicedMenu1 = specialMenu.stream()
        .takeWhile(d -> d.getCalories() < 320)
        .collect(toList());
    slicedMenu1.forEach(System.out::println);

    System.out.println("Sorted menu sliced with dropWhile():");
    List<Dish> slicedMenu2 = specialMenu.stream()
        .dropWhile(d -> d.getCalories() < 320)
        .collect(toList());
    slicedMenu2.forEach(System.out::println);

    // 스트림 연결
    List<Dish> dishesLimit3 = menu.stream()
        .filter(d -> d.getCalories() > 300)
        .limit(3)
        .collect(toList());
    System.out.println("Truncating a stream:");
    dishesLimit3.forEach(System.out::println);

    // 요소 생략
    List<Dish> dishedSkip2 = menu.stream()
        .filter(d -> d.getCalories() > 300)
        .skip(2)
        .collect(toList());
    System.out.println("Skipping elements:");
    dishedSkip2.forEach(System.out::println);
  }

}
