package dev.coma.data.sort;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class QuickSort2 {
  public static void main(String[] args) {
    int num;
    int[] arr;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("퀵 정렬 Ver.1 Not Recur");
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
    Deque<Integer> leftStack = new ArrayDeque<>();
    Deque<Integer> rightStack = new ArrayDeque<>();

    leftStack.push(start);
    rightStack.push(end);

    while (!leftStack.isEmpty()) {
      int leftPointer = start = leftStack.pop();
      int rightPointer = end = rightStack.pop();
      int pivot = arr[(leftPointer + rightPointer) / 2];

      do {
        while (arr[leftPointer] < pivot) leftPointer++;
        while (arr[rightPointer] > pivot) rightPointer--;

        if (leftPointer <= rightPointer) swap(arr, leftPointer++, rightPointer--);
      } while (leftPointer <= rightPointer);

      if (start < rightPointer) {
        leftStack.push(start);
        rightStack.push(rightPointer);
      }

      if (end > leftPointer) {
        leftStack.push(leftPointer);
        rightStack.push(end);
      }
    }



  }
}
