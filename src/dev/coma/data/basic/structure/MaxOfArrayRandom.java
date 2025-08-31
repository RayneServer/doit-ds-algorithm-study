package dev.coma.data.basic.structure;

import java.util.Random;
import java.util.Scanner;

public class MaxOfArrayRandom {
  public static void main(String[] args) {
    Random random = new Random();
    try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("키의 최대값 구하기");
			System.out.print("사람 수: ");
			int[] height = new int[scanner.nextInt()];

			System.out.println("키 값은 아래와 같습니다.");
			for (int i = 0; i < height.length; i++) {
			  height[i] = 100 + random.nextInt(90);
			  System.out.println("height[" + i + "]: " + height[i]);
			}

			System.out.println("최대값은 " + maxOf(height) + "입니다.");
		}
  }

  static int maxOf(int[] a) {
    int max = a[0];
    for (int i = 1; i < a.length; i++) {
      if (a[i] > max) max = a[i];
    }

    return max;
  }
}
