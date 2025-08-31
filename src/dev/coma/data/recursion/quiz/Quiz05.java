package dev.coma.data.recursion.quiz;

import java.util.Scanner;

public class Quiz05 {
  static int count = 0;

  static void recur(int n) {
    count++;
    if (n > 0) {
      recur(n - 1);
      System.out.println(n);
      recur(n - 2);
    }
  }

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("정수를 입력하세요: ");
			int num = scanner.nextInt();

			recur(num);
		}

    System.out.println("총 메서드 호출 횟수: " + count);
  }
}
