package dev.coma.data.match;

import java.util.Scanner;

public class IndexOfTester {
  public static void main(String[] args) {
    String input;
    String word;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("텍스트: ");
      input = scanner.nextLine();

      System.out.print("패턴: ");
      word = scanner.nextLine();
    }

    int resultIndex1 = input.indexOf(word);
    int resultIndex2 = input.lastIndexOf(word);

    if (resultIndex1 == -1) System.out.println("텍스트에 패턴이 없습니다.");
    else {
      int length1 = 0;
      for (int i = 0; i < resultIndex1; i++) {
        length1 += input.substring(i, i + 1).getBytes().length;
      }

      length1 += word.length();

      int length2 = 0;
      for (int i = 0; i < resultIndex2; i++) {
        length2 += input.substring(i, i + 1).getBytes().length;
      }

      length2 += word.length();

      System.out.println("텍스트: " + input);
      System.out.printf(String.format("패턴: %%%ds\n", length1), word);
      System.out.println("텍스트: " + input);
      System.out.printf(String.format("패턴: %%%ds\n", length2), word);
    }
  }
}
