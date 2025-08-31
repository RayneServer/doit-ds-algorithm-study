package dev.coma.data.basic.algorithm.quiz;

import java.util.Scanner;

public class Quiz09 {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("a값: ");
			int inputA = scanner.nextInt();
			int inputB;

			do {
			  System.out.print("b값: ");
			  inputB = scanner.nextInt();

			  if (inputB <= inputA) System.out.println("a보다 큰 값을 입력하세요!");
			} while (inputB <= inputA);

			System.out.println("b - a는 " + (inputB - inputA) + "입니다.");
		}
  }
}
