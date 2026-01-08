package dev.coma.data.sort;

import java.util.Scanner;

public class QuickSort3 {
  public static void main(String[] args) {
    int num;
    int[] arr;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("퀵 정렬 Ver.2");
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

  private static int sortThreeElement(int[] arr, int a, int b, int c) {
    if (arr[b] < arr[a]) swap(arr, b, a);
    if (arr[c] < arr[b]) swap(arr, c, b);
    if (arr[b] < arr[a]) swap(arr, b, a);

    return b;
  }

  private static void quickSort(int[] arr, int start, int end) {
    int leftPointer = start;
    int rightPointer = end;
    int pivotIdx = sortThreeElement(arr, start, (start + end) / 2, end);
    int pivot = arr[pivotIdx];

    swap(arr, pivotIdx, end - 1);
    leftPointer++;
    rightPointer -= 2;

    do {
      while (arr[leftPointer] < pivot) leftPointer++;
      while (arr[rightPointer] > pivot) rightPointer--;

      if (leftPointer <= rightPointer) swap(arr, leftPointer++, rightPointer--);
    } while (leftPointer <= rightPointer);

    if (start < rightPointer) quickSort(arr, start, rightPointer);
    if (end > leftPointer) quickSort(arr, leftPointer, end);
  }
}
