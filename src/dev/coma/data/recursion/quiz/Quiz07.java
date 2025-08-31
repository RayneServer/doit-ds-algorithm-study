package dev.coma.data.recursion.quiz;

import java.util.Scanner;

public class Quiz07 {
  static void move(int plateNum, int startPill, int targetPill) {
    if (plateNum > 1) move(plateNum - 1, startPill, 6 - startPill - targetPill);

    System.out.printf("원반[%d]을(를) %s에서 %s으로 옮김\n", plateNum, pillarName(startPill), pillarName(targetPill));

    if (plateNum > 1) move(plateNum - 1, 6 - startPill - targetPill, targetPill);
  }

  static String pillarName(int num) {
    return switch (num) {
      case 1 -> "A 기둥";
      case 2 -> "B 기둥";
      case 3 -> "C 기둥";
      default -> "";
    };
  }

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("하노이의 탑");
			System.out.print("원반의 개수: ");
			int num = scanner.nextInt();

			move(num, 1, 3);
		}
  }
}
