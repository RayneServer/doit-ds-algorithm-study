package dev.coma.data.sort;

import java.util.Scanner;

public class QuickSortV {
  public static void main(String[] args) {
    int num;
    int[] arr;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("퀵 정렬 Ver.1");
      System.out.print("요소수: ");
      num = scanner.nextInt();

      arr = new int[num];
      for (int i = 0; i < num; i++) {
        System.out.printf("arr[%s]:", i);
        arr[i] = scanner.nextInt();
      }
    }

    quickSort(arr, 0, num - 1);

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

  private static void quickSort(int[] arr, int start, int end) {
    int leftPointer = start;
    int rightPointer = end;
    int pivot = arr[(start + end) / 2];

    System.out.printf("arr[%s] ~ arr[%s]: {", start, end);
    for (int i = start; i <= end - 1; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println(arr[end] + "}");

    do {
      while (arr[leftPointer] < pivot) leftPointer++;
      while (arr[rightPointer] > pivot) rightPointer--;

      if (leftPointer <= rightPointer) swap(arr, leftPointer++, rightPointer--);
    } while (leftPointer <= rightPointer);

    if (start < rightPointer) quickSort(arr, start, rightPointer);
    if (end > leftPointer) quickSort(arr, leftPointer, end);
  }
}
