package dev.coma.data.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz14 {
  public static void main(String[] args) {
    int num;
    int[] arr;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("퀵 정렬 Ver.2++");
      System.out.print("요소수: ");
      num = scanner.nextInt();

      arr = new int[num];
      for (int i = 0; i < num; i++) {
        System.out.printf("arr[%s]:", i);
        arr[i] = scanner.nextInt();
      }
    }

    quickSort(arr, num);

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

  private static void quickSort(int[] arr, int num) {
    if (num <= 9) {
      insertionSort(arr, num);
      return;
    }

    int leftPointer = 0;
    int rightPointer = num - 1;
    int pivotIdx = sortThreeElement(arr, 0, (num - 1) / 2, num - 1);
    int pivot = arr[pivotIdx];

    swap(arr, pivotIdx, num - 2);
    leftPointer++;
    rightPointer -= 2;

    do {
      while (arr[leftPointer] < pivot) leftPointer++;
      while (arr[rightPointer] > pivot) rightPointer--;

      if (leftPointer <= rightPointer) swap(arr, leftPointer++, rightPointer--);
    } while (leftPointer <= rightPointer);

    if (0 < rightPointer) {
      int[] newArr = Arrays.copyOfRange(arr, 0, rightPointer + 1);
      int newNum = rightPointer + 1;

      quickSort(newArr, newNum);

      for (int i = 0; i < newNum; i++) {
        arr[i] = newArr[i];
      }
    }

    if (num - 1 > leftPointer) {
      int[] newArr = Arrays.copyOfRange(arr, leftPointer, num);
      int newNum = num - leftPointer;

      quickSort(newArr, newNum);

      for (int i = 0; i < newNum; i++) {
        arr[i + leftPointer] = newArr[i];
      }
    }
  }

  public static void insertionSort(int[] arr, int num) {
    for (int i = 1; i < num; i++) {
      int pointer;
      int temp = arr[i];

      for (pointer = i; pointer > 0 && arr[pointer - 1] > temp; pointer--) {
        arr[pointer] = arr[pointer - 1];
      }

      arr[pointer] = temp;
    }
  }
}
