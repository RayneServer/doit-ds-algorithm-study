package dev.coma.data.sort;

import java.util.Scanner;

public class BubbleSort3 {
  public static void main(String[] args) {
    int num;
    int[] arr;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("버블 정렬 Ver.3");
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
    int pointer = 0;

    while (pointer < num - 1) {
      int lastSwapIdx = num - 1;

      for (int i = num - 1; i > pointer; i--) {
        if (arr[i - 1] > arr[i]) {
          swap(arr, i - 1, i);
          lastSwapIdx = i;
        }
      }

      pointer = lastSwapIdx;
    }
  }
}
