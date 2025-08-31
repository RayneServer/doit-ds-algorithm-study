package dev.coma.data.basic.structure;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber3 {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    int mulDivCount = 0;

    list.add(2);
    list.add(3);

    Master:
    for (int n = 5; n <= 1000; n += 2) {
      for (int i = 1; (list.get(i) * list.get(i)) <= n; i++) {
        mulDivCount += 2;
        if (n % list.get(i) == 0) continue Master;
      }

      list.add(n);
      mulDivCount++;
    }

    for (Integer i : list) {
      System.out.println(i);
    }

    System.out.println("곱셈 및 나눗셈 횟수: " + mulDivCount);
  }
}
