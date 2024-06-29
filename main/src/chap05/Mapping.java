package chap05;

import static chap04.Dish.menu;
import static java.util.stream.Collectors.toList;

import chap04.Dish;
import java.util.Arrays;
import java.util.List;

public class Mapping {

  public static void main(String[] args) {
    // map
    List<String> dishNames = menu.stream()
        .map(Dish::getName)
        .collect(toList());
    System.out.println(dishNames);

    // map
    List<String> words = Arrays.asList("Hello", "World");
    List<Integer> wordLengths = words.stream()
        .map(String::length)
        .collect(toList());
    System.out.println(wordLengths);

    // flatMap
    words.stream()
        .flatMap((String line) -> Arrays.stream(line.split("")))
        .distinct()
        .forEach(System.out::println);

  }
}
