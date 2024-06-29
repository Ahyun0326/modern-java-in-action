package chap05;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PuttingInfoPractice {

  public static void main(String[] args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 3000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(brian, 2012, 700),
        new Transaction(alan, 2012, 950)
    );

    List<Transaction> result1 = transactions.stream()
        .filter(t -> t.getYear() == 2011)
        .sorted(comparing(Transaction::getValue))
        .collect(toList());
    System.out.println(result1);

    List<String> result2 = transactions.stream()
        .map(t -> t.getTrader().getCity())
        .distinct()
        .collect(toList());
    System.out.println(result2);

    List<Trader> result3 = transactions.stream()
        .map(Transaction::getTrader)
        .filter(trader -> trader.getCity() == "Cambridge")
        .distinct()
        .sorted(comparing(Trader::getName))
        .collect(toList());
    System.out.println(result3);

    String result4 = transactions.stream()
        .map(t -> t.getTrader().getName())
        .distinct()
        .sorted()
        .reduce("", (n1, n2) -> (n1 + n2));
    System.out.println(result4);

    boolean result5 = transactions.stream()
        .anyMatch(t -> t.getTrader().getCity() == "Milan");
    System.out.println(result5);

    transactions.stream()
        .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
        .map(Transaction::getValue)
        .forEach(System.out::println);

    Optional<Integer> highestValue = transactions.stream()
        .map(Transaction::getValue)
        .reduce(Integer::max);

    Optional<Integer> smallestValue = transactions.stream()
        .map(Transaction::getValue)
        .reduce(Integer::min);

  }

}
