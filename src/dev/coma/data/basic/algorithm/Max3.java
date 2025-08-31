package dev.coma.data.basic.algorithm;

import java.util.Scanner;

public class Max3 {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("세 정수의 최대값 구하기");

			System.out.print("a의 값: ");
			int inputA = scanner.nextInt();

			System.out.print("b의 값: ");
			int inputB = scanner.nextInt();

			System.out.print("c의 값: ");
			int inputC = scanner.nextInt();

			int max = inputA;
			if (inputB > max) max = inputB;
			if (inputC > max) max = inputC;

			System.out.printf("최대값은 %d입니다.", max);
		}
  }
}
