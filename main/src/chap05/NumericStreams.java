package chap05;

import static chap04.Dish.*;

import chap04.Dish;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreams {

  public static void main(String[] args) {

    int calories = menu.stream()
        .mapToInt(Dish::getCalories)
        .sum();
    System.out.println("Number of calories:" + calories);

    IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
    Stream<Integer> stream = intStream.boxed();// 숫자 스트림을 스트림으로 변환

    // max와 OptionalInt
    OptionalInt maxCalories = menu.stream()
        .mapToInt(Dish::getCalories)
        .max();
    int max;
    if (maxCalories.isPresent()) {
      max = maxCalories.getAsInt();
    } else {
      max = 1;
    }
    System.out.println(max);

    // 숫자 범위
    IntStream evenNumbers = IntStream.rangeClosed(1, 100) //[1,100]의 범위를 나타냄
        .filter(n -> n % 2 == 0);
    System.out.println(evenNumbers.count());

    Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
        .flatMap(a -> IntStream.rangeClosed(a, 100)
            .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed()
            .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));  //각 요소를 피타고라스 수로 변환
    pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
  }
}