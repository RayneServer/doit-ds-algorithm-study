package dev.coma.data.basic.algorithm;

import java.util.Scanner;

public class JudgeSign {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("정수를 입력하세요: ");
			int inputNum = scanner.nextInt();

			if (inputNum > 0) {
			  System.out.println("이 수는 양수입니다.");
			} else if (inputNum < 0) {
			  System.out.println("이 수는 음수입니다.");
			} else {
			  System.out.println("이 수는 0입니다.");
			}
		}
  }
}
