package dev.coma.data.basic.algorithm;

import java.util.Scanner;

public class SumVerbose1 {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			int inputNum;
			System.out.println("1부터 n까지의 합 구하기");
			do {
			  System.out.print("n의 값: ");
			  inputNum = scanner.nextInt();
			} while (inputNum <= 0);

			int sum = 0;
			for (int i = 1; i <= inputNum; i++) {
			  if (i < inputNum) System.out.print(i + " + ");
			  else System.out.print(i + " = ");

			  sum += i;
			}

			System.out.println(sum);
		}
  }
}
