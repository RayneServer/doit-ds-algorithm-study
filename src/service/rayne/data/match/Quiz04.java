package service.rayne.data.match;

import java.util.Scanner;

public class Quiz04 {
  public static void main(String[] args) {
    String input;
    String word;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("텍스트: ");
      input = scanner.nextLine();

      System.out.print("패턴: ");
      word = scanner.nextLine();
    }

    int resultIndex = bmMatch(input, word);

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

  private static int bmMatch(String input, String word) {
    int[] skipArr = new int[Character.MAX_VALUE + 1];
    int pointer;
    int counter;

    for (pointer = 0; pointer <= Character.MAX_VALUE; pointer++) {
      skipArr[pointer] = word.length();
    }

    for (pointer = 0; pointer < word.length() - 1; pointer++) {
      skipArr[word.charAt(pointer)] = word.length() - pointer - 1;
    }

    int repeater = 0;
    while (pointer < input.length()) {
      System.out.println(input);
      System.out.print(" ".repeat(pointer));
      counter = word.length() - 1;

      while (counter >= 0 && input.charAt(pointer) == word.charAt(counter)) {
        System.out.println("+");
        System.out.println(" ".repeat(repeater) + word);
        System.out.println();

        if (counter == 0) return pointer;

        pointer--;
        counter--;

        System.out.println(input);
        System.out.print(" ".repeat(pointer));
      }

      System.out.println("|");
      System.out.println(" ".repeat(repeater) + word);
      System.out.println();

      pointer += Math.max(skipArr[input.charAt(pointer)], word.length() - counter);
      repeater = pointer - word.length() + 1;
    }

    return -1;
  }
}
