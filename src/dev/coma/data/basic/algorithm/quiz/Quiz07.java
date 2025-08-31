package dev.coma.data.basic.algorithm.quiz;

import java.util.Scanner;

public class Quiz07 {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			int inputNum = scanner.nextInt();

			int sum;
			if (inputNum % 2 == 0) {
			  sum = (1 + inputNum) * (inputNum / 2);
			} else {
			  sum = (1 + (inputNum - 1)) * ((inputNum - 1) / 2) + inputNum;
			}

			System.out.printf("1 부터 %d 까지의 합은 %d 입니다.", inputNum, sum);
		}
  }
}
