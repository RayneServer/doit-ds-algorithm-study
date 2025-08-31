package dev.coma.data.recursion.quiz;

import java.util.Scanner;

public class Quiz01 {
  static int factorial(int n) {
    int result = 1;
    for (int i = 1; i <= n; i++) {
      result *= i;
    }

    return result;
  }

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("정수를 입력하세요: ");
			int num = scanner.nextInt();

			System.out.println(num + "의 팩토리얼 값은 " + factorial(num) + "입니다.");
		}
  }
}
