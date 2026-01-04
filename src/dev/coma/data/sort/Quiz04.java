package dev.coma.data.sort;

import java.util.Scanner;

public class Quiz04 {
  private static int compareCount;
  private static int swapCount;

  public static void main(String[] args) {
    int num;
    int[] arr;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("버블 정렬 Ver.3++");
      System.out.print("요소수: ");
      num = scanner.nextInt();

      arr = new int[num];
      for (int i = 0; i < num; i++) {
        System.out.printf("arr[%s]:", i);
        arr[i] = scanner.nextInt();
      }
    }

    bubbleSort(arr, num);

    System.out.printf("비교를 %s회 했습니다.\n", compareCount);
    System.out.printf("교환을 %s회 했습니다.\n", swapCount);
  }

  private static void swap(int[] arr, int idx1, int idx2) {
    int temp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = temp;

    swapCount++;
  }

  private static void bubbleSort(int[] arr, int num) {
    int pointer = 0;
    int passCount = 1;

    while (pointer < num - 1) {
      System.out.printf("Pass %s:\n", passCount++);
      int lastSwapIdx = num - 1;

      for (int i = num - 1; i > pointer; i--) {
        if (arr[i - 1] > arr[i]) {
          printArr(arr, i - 1, true);
          swap(arr, i - 1, i);
          lastSwapIdx = i;
        } else {
          printArr(arr, i - 1, false);
        }

        compareCount++;
      }

      printArr(arr, -1, false); // 단순 출력용 매개변수 입력
      System.out.println();

      pointer = lastSwapIdx;
    }
  }

  private static void printArr(int[] arr, int idx, boolean isSwap) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);

      if (i == idx) System.out.print(isSwap ? "+" : "-");
      else System.out.print(" ");
    }

    System.out.println();
  }
}
