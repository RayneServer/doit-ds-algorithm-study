package dev.coma.data.basic.algorithm.quiz;

import java.util.Scanner;

public class Quiz13 {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("정사각형을 출력합니다.");

			int inputN;
			do {
			  System.out.print("변의 길이: ");
			  inputN = scanner.nextInt();
			} while (inputN <= 0);

			for (int i = 1; i <= inputN; i++) {
			  System.out.print("*".repeat(inputN));
			  System.out.println();
			}
		}
  }
}
