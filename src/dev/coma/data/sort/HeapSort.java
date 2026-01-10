package dev.coma.data.sort;

import java.util.Scanner;

public class HeapSort {
  public static void main(String[] args) {
    int num;
    int[] arr;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("힙 정렬");
      System.out.print("요소수: ");
      num = scanner.nextInt();

      arr = new int[num];
      for (int i = 0; i < num; i++) {
        System.out.printf("arr[%s]:", i);
        arr[i] = scanner.nextInt();
      }
    }

    heapSort(arr);

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

  private static void downHeap(int[] arr, int start, int end) {
    int rootValue = arr[start];
    int bigChildIndex;
    int parentIndex;

    for (parentIndex = start; parentIndex < (end + 1) / 2; parentIndex = bigChildIndex) {
      int leftChild = (parentIndex * 2) + 1;
      int rightChild = leftChild + 1;

      bigChildIndex = (rightChild <= end && arr[rightChild] > arr[leftChild]) ? rightChild : leftChild;
      if (rootValue >= arr[bigChildIndex]) break;

      arr[parentIndex] = arr[bigChildIndex];
    }

    arr[parentIndex] = rootValue;
  }

  private static void heapSort(int[] arr) {
    for (int i = (arr.length - 1) / 2; i >= 0; i--) {
      downHeap(arr, i, arr.length - 1);
    }

    for (int i = arr.length - 1; i > 0; i--) {
      swap(arr, 0, i);
      downHeap(arr, 0, i - 1);
    }
  }
}
