package service.rayne.data.match;

import java.util.Scanner;

public class Quiz03 {
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
    int repeater = 0;
    int temp = 0;
    while (pointer != input.length() && counter != word.length()) {
      System.out.println(input);
      System.out.print(" ".repeat(pointer));

      if (input.charAt(pointer) == word.charAt(counter)) {
        System.out.println("+");
        temp = 0;
        pointer++;
        counter++;
      } else if (counter == 0) {
        System.out.println("|");
        temp = 1;
        pointer++;
      } else {
        System.out.println("|");
        temp = counter - skipArr[counter];
        counter = skipArr[counter];
      }

      System.out.println(" ".repeat(repeater) + word);
      repeater += temp;
      System.out.println();
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
