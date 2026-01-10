package dev.coma.data.sort;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysSortTester {
  public static void main(String[] args) {
    int num;
    int[] arr;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("요소수: ");
      num = scanner.nextInt();

      arr = new int[num];
      for (int i = 0; i < num; i++) {
        System.out.printf("arr[%s]:", i);
        arr[i] = scanner.nextInt();
      }
    }

    Arrays.sort(arr);

    System.out.println("오름차순으로 정렬했습니다.");
    for (int i = 0; i < num; i++) {
      System.out.printf("arr[%s] = %s\n", i, arr[i]);
    }
  }
}
