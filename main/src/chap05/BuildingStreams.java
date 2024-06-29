package chap05;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreams {

  public static void main(String[] args) {
    // Stream.of
    Stream<String> stream = Stream.of("Modern ","Java ","In ","Action");
    stream.map(String::toUpperCase).forEach(System.out::println);

    // Stream.empty
    Stream<String> emptyStream = Stream.empty();

    // Arrays.stream
    int[] numbers = {2, 3, 5, 7, 11, 13};
    System.out.println(Arrays.stream(numbers).sum());

    // Stream.iterate
    Stream.iterate(0, n-> n+2)
        .limit(10)
        .forEach(System.out::println);

    // iterate를 이용한 피보나치
    Stream.iterate(new int[]{0, 1}, t -> new int[] {t[1], t[0]+t[1]})
        .limit(20)
        .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

    // Stream.generate를 이용한 임의의 double 스트림
    Stream.generate(Math::random) // 0~1 사이의 임의의 더블 숫자 다섯 개 생성
        .limit(5)
        .forEach(System.out::println);

    // Stream.generate를 이용한 요소 1을 갖눈 스트림
    IntStream.generate(() -> 1)
        .limit(5)
        .forEach(System.out::println);


  }

}
