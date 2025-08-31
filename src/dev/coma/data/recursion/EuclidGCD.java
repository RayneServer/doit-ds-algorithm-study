package dev.coma.data.recursion;

import java.util.Scanner;

public class EuclidGCD {
  static int gcd(int x, int y) {
    if (y == 0) return x;
    else return gcd(y, x % y);
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
