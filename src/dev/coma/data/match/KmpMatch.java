package dev.coma.data.match;

import java.util.Scanner;

public class KmpMatch {
  public static void main(String[] args) {
    String input;
    String word;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("텍스트: ");
      input = scanner.nextLine();

      System.out.print("패턴: ");
      word = scanner.nextLine();
    }

    int resultIndex = kmpMatch(input, word);

    if (resultIndex == -1) System.out.println("텍스트에 패턴이 없습니다.");
    else {
      int length = 0;
      for (int i = 0; i < resultIndex; i++) {
        length += input.substring(i, i + 1).getBytes().length;
      }

      length += word.length();

      System.out.println((resultIndex + 1) + "번째 문자부터 일치합니다.");
      System.out.println("텍스트: " + input);
      System.out.printf(String.format("패턴: %%%ds\n", length), word);
    }
  }

  private static int kmpMatch(String input, String word) {
    int[] skipArr = makeSkipArr(word);

    int pointer = 0;
    int counter = 0;
    while (pointer != input.length() && counter != word.length()) {
      if (input.charAt(pointer) == word.charAt(counter)) {
        pointer++;
        counter++;
      } else if (counter == 0) {
        pointer++;
      } else {
        counter = skipArr[counter];
      }
    }

    if (counter == word.length()) return pointer - counter;
    else return -1;
  }

  private static int[] makeSkipArr(String word) {
    int[] skipArr = new int[word.length() + 1];

    int pointer = 1;
    int counter = 0;
    while (pointer != word.length()) {
      if (word.charAt(pointer) == word.charAt(counter)) {
        skipArr[++pointer] = ++counter;
      } else if (counter == 0) {
        skipArr[++pointer] = counter;
      } else {
        counter = skipArr[counter];
      }
    }

    return skipArr;
  }
}
