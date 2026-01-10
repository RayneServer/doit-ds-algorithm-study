package dev.coma.data.sort;

import java.util.Scanner;

public class MergeSort {
  private static int[] buffer;

  public static void main(String[] args) {
    int num;
    int[] arr;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("병합 정렬");
      System.out.print("요소수: ");
      num = scanner.nextInt();

      arr = new int[num];
      for (int i = 0; i < num; i++) {
        System.out.printf("arr[%s]:", i);
        arr[i] = scanner.nextInt();
      }
    }

    mergeSort(arr);

    System.out.println("오름차순으로 정렬했습니다.");
    for (int i = 0; i < num; i++) {
      System.out.printf("arr[%s] = %s\n", i, arr[i]);
    }
  }

  private static void mergeSort(int[] arr) {
    buffer = new int[arr.length];
    mergeSortProcess(arr, 0, arr.length - 1);
    buffer = null;
  }

  private static void mergeSortProcess(int[] arr, int start, int end) {
    if (start >= end) return;

    int center = (start + end) / 2;
    mergeSortProcess(arr, start, center);
    mergeSortProcess(arr, center + 1, end);

    int arrCountIndex = start;
    int arrFillIndex = start;
    int bufferFillIndex = 0;
    int bufferCountIndex = 0;

    for (; arrCountIndex <= center; arrCountIndex++) {
      buffer[bufferFillIndex++] = arr[arrCountIndex];
    }

    while (arrCountIndex <= end && bufferCountIndex < bufferFillIndex) {
      arr[arrFillIndex++] = (buffer[bufferCountIndex] <= arr[arrCountIndex]) ? buffer[bufferCountIndex++] : arr[arrCountIndex++];
    }

    while (bufferCountIndex < bufferFillIndex) arr[arrFillIndex++] = buffer[bufferCountIndex++];
  }
}
