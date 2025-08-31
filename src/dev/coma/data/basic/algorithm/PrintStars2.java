package dev.coma.data.basic.algorithm;

import java.util.Scanner;

public class PrintStars2 {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("*을 n개 출력합니다.\nw개마다 줄을 바꿉니다.");

			int inputN, inputW;
			do {
			  System.out.print("n의 값: ");
			  inputN = scanner.nextInt();
			} while (inputN <= 0);

			do {
			  System.out.print("w의 값: ");
			  inputW = scanner.nextInt();
			} while (inputW <= 0 || inputW > inputN);

			for (int i = 0; i < (inputN / inputW); i++) {
			  System.out.println("*".repeat(inputW));
			}

			int rest = inputN % inputW;
			if (rest != 0) System.out.println("*".repeat(rest));
		}
  }
}