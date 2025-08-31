package dev.coma.data.basic.algorithm;

import java.util.Scanner;

public class TwoDigits {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("2자리의 양수를 입력하세요.");

			int inputNo;
			do {
			  System.out.print("no의 값: ");
			  inputNo = scanner.nextInt();
			} while (inputNo < 10 || inputNo > 99);

			System.out.println("변수 no의 값은 " + inputNo + "이 되었습니다.");
		}
  }
}
