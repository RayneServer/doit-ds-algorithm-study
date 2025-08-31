package dev.coma.data.recursion.quiz;

import java.util.Scanner;

public class Quiz02 {
  static int gcd(int x, int y) {
    while (true) {
      int num = x % y;
      if (num == 0) return y;

      int temp = x;
      x = y;
      y = temp % y;
    }
  }

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("두 정수의 최대공약수 구하기");

			System.out.print("정수를 입력하세요: ");
			int numX = scanner.nextInt();

			System.out.print("정수를 입력하세요: ");
			int numY = scanner.nextInt();

			System.out.println("두 정수의 최대공약수는 " + gcd(numX, numY) + "입니다.");
		}
  }
}
