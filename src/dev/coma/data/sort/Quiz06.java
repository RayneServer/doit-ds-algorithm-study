package dev.coma.data.sort;

import java.util.Scanner;

public class Quiz06 {
  public static void main(String[] args) {
    int num;
    int[] arr;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("선택 정렬 Ver.1++");
      System.out.print("요소수: ");
      num = scanner.nextInt();

      arr = new int[num];
      for (int i = 0; i < num; i++) {
        System.out.printf("arr[%s]:", i);
        arr[i] = scanner.nextInt();
      }
    }

    selectionSort(arr, num);

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

  private static void selectionSort(int[] arr, int num) {
    for (int i = 0; i < num - 1; i++) {
      int minIndex = i;

      for (int j = i + 1; j < num; j++) {
        if (arr[j] < arr[minIndex]) minIndex = j;
      }

      printArr(arr, i, minIndex);
      swap(arr, i, minIndex);
    }
  }

  private static void printArr(int[] arr, int selectIndex, int minIndex) {
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < arr.length; i++) {
      if (i == selectIndex) stringBuilder.append("* ");
      else if (i == minIndex) stringBuilder.append("+ ");
      else stringBuilder.append("  ");
    }

    System.out.println(stringBuilder);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }

    System.out.println();
  }
}
