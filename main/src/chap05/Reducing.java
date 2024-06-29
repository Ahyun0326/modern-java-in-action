package chap05;

import static chap04.Dish.menu;

import chap04.Dish;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
    int sum = numbers.stream().reduce(0, (a, b) -> a + b);
    System.out.println(sum);

    int sum2 = numbers.stream().reduce(0, Integer::sum);
    System.out.println(sum2);

    int product = numbers.stream().reduce(1, (a, b) -> a * b);
    System.out.println(product);

    Optional<Integer> max = numbers.stream().reduce(Integer::max);
    max.ifPresent(System.out::println);

    int count = menu.stream()
        .map(d -> 1)
        .reduce(0, (a, b) -> (a + b));
    System.out.println(count);
  }
}
