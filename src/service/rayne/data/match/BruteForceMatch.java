package service.rayne.data.match;

import java.util.Scanner;

public class BruteForceMatch {
  public static void main(String[] args) {
    String input;
    String word;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("텍스트: ");
      input = scanner.nextLine();

      System.out.print("패턴: ");
      word = scanner.nextLine();
    }

    int resultIndex = bruteForce(input, word);

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

  private static int bruteForce(String input, String word) {
    int inputPointer = 0;
    int wordPointer = 0;

    while (inputPointer != input.length() && wordPointer != word.length()) {
      if (input.charAt(inputPointer) == word.charAt(wordPointer)) {
        inputPointer++;
        wordPointer++;
      } else {
        inputPointer = inputPointer - wordPointer + 1;
        wordPointer = 0;
      }
    }

    if (wordPointer == word.length()) return inputPointer - wordPointer;
    return -1;
  }
}
