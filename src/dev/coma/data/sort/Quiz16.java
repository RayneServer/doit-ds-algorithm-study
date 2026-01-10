package dev.coma.data.sort;

import java.util.Scanner;

public class Quiz16 {
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
    printArr(arr);

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

  private static void printArr(int[] arr) {
    System.out.println();
    int level = getLevel(arr.length);

    int space = 0;
    int num = 1;
    for (int i = 0; i < level; i++) {
      num *= 2;
      space += num;
    }

    int lineCount = 1;
    System.out.print(" ".repeat(space - num));
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("%02d", arr[i]);

      if (i < lineCount - 1) System.out.print(" ".repeat(space));
      else {
        System.out.println();
        lineCount += (lineCount + 1);
        space -= num;
        num /= 2;
        System.out.print(" ".repeat(space - num));
      }

    }

    System.out.println();
  }

  private static int getLevel(int length) {
    int level = 0;

    while (length > 0) {
      length /= 2;
      level++;
    }

    return level;
  }
}
