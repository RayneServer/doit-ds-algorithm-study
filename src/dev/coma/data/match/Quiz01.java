package dev.coma.data.match;

import java.util.Scanner;

public class Quiz01 {
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
    int inputPointer = input.length() - 1;
    int wordPointer = word.length() - 1;
    int counter = 1;
    int repeater = inputPointer - wordPointer + 1;
    boolean isMove = true;

    while (inputPointer >= 0 && wordPointer >= 0) {
      if (isMove) {
        System.out.println(counter++ + "회차");
        repeater--;
        isMove = false;
      }

      System.out.println(input);
      System.out.print(" ".repeat(inputPointer));

      if (input.charAt(inputPointer) == word.charAt(wordPointer)) {
        System.out.println("+");
        inputPointer--;
        wordPointer--;
      } else {
        System.out.println("|");
        inputPointer = inputPointer + (word.length() - wordPointer) - 2;
        wordPointer = word.length() - 1;
        isMove = true;
      }

      System.out.println(" ".repeat(repeater) + word);
      System.out.println();
    }

    if (wordPointer < 0) return inputPointer + 1;
    return -1;
  }
}
