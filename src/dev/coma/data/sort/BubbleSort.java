package dev.coma.data.sort;

import java.util.Scanner;

public class BubbleSort {
  public static void main(String[] args) {
    int num;
    int[] arr;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("버블 정렬 Ver.1");
      System.out.print("요소수: ");
      num = scanner.nextInt();

      arr = new int[num];
      for (int i = 0; i < num; i++) {
        System.out.printf("arr[%s]:", i);
        arr[i] = scanner.nextInt();
      }
    }

    bubbleSort(arr, num);

    System.out.println("오름차순으로 정렬했습니다.");
    for (int i = 0; i < num; i++) {
      System.out.printf("arr[%s] = %s\n", i, arr[i]);
    }
  }

  private static void swap(int[] arr, int idx1, int idx2) {
    int temp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = temp;
  }

  private static void bubbleSort(int[] arr, int num) {
    for (int i = 0; i < num - 1; i++) {
      for (int j = num - 1; j > i; j--) {
        if (arr[j - 1] > arr[j]) swap(arr, j - 1, j);
      }
    }
  }
}
