import java.util.ArrayList;
import java.util.List;

public class PrimeNumber2 {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    int divCount = 0;

    list.add(2);

    Master:
    for (int n = 3; n <= 1000; n++) {
      for (Integer i : list) {
        divCount++;
        if (n % i == 0) continue Master;
      }

      list.add(n);
    }

    for (Integer i : list) {
      System.out.println(i);
    }

    System.out.println("나눗셈 횟수: " + divCount);
  }
}
