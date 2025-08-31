package dev.coma.data.basic.algorithm;

import java.util.Scanner;

public class SumFor {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("1부터 n까지의 합 구하기");
			System.out.print("n의 값: ");
			int inputNum = scanner.nextInt();

			int sum = 0;
			for (int i = 1; i <= inputNum; i++) {
			  sum += i;
			}

			System.out.printf("1부터 %d까지의 합은 %d입니다.\n", inputNum, sum);
		}
  }
}
