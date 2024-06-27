package chap04;

import static chap04.Dish.menu;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class HighCaloriesNames {

  public static void main(String[] args) {
    List<String> threeHighCaloricDishNames = menu.stream()  // 메뉴(요리 리스트)에서 스트림을 얻는다.
        .filter(dish -> dish.getCalories() > 300) // 파이프라인 연산 만들기, 첫 번째로 고칼로리 요리를 필터링한다.
        .map(Dish::getName) // 요리명 추출
        .limit(3) // 선착순 세 개만 선택
        .collect(toList()); //결과를 다른 리스트로 저장
    System.out.println(threeHighCaloricDishNames);  // 결과: [pork, beef, chicken]
  }
}
