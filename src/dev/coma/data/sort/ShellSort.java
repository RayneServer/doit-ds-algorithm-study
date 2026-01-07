package dev.coma.data.sort;

import java.util.Scanner;

public class ShellSort {
  public static void main(String[] args) {
    int num;
    int[] arr;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Shell 정렬 Ver.1");
      System.out.print("요소수: ");
      num = scanner.nextInt();

      arr = new int[num];
      for (int i = 0; i < num; i++) {
        System.out.printf("arr[%s]:", i);
        arr[i] = scanner.nextInt();
      }
    }

    shellSort(arr, num);

    System.out.println("오름차순으로 정렬했습니다.");
    for (int i = 0; i < num; i++) {
      System.out.printf("arr[%s] = %s\n", i, arr[i]);
    }
  }

  private static void shellSort(int[] arr, int num) {
    int h = num / 2;

    while (h > 0) {
      for (int i = h; i < num; i++) {
        int pointer;
        int temp = arr[i];

        for (pointer = i - h; pointer >= 0 && arr[pointer] > temp; pointer -= h) {
          arr[pointer + h] = arr[pointer];
        }

        arr[pointer + h] = temp;
      }

      h /= 2;
    }
  }
}
