package dev.coma.data.sort;

import java.util.Scanner;

public class Partition {
  public static void main(String[] args) {
    int num;
    int[] arr;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("배열을 나눕니다.");
      System.out.print("요소수: ");
      num = scanner.nextInt();

      arr = new int[num];
      for (int i = 0; i < num; i++) {
        System.out.printf("arr[%s]:", i);
        arr[i] = scanner.nextInt();
      }
    }

    partition(arr, num);
  }

  private static void swap(int[] arr, int idx1, int idx2) {
    int temp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = temp;
  }

  private static void partition(int[] arr, int num) {
    int leftPointer = 0;
    int rightPointer = num - 1;
    int pivot = arr[num / 2];

    do {
      while (arr[leftPointer] < pivot) leftPointer++;
      while (arr[rightPointer] > pivot) rightPointer--;

      if (leftPointer <= rightPointer) swap(arr, leftPointer++, rightPointer--);
    } while (leftPointer <= rightPointer);

    System.out.println("Pivot 값은 " + pivot + "입니다.");

    System.out.println("피벗 이하의 그룹");
    for (int i = 0; i < leftPointer; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();

    if (leftPointer > rightPointer + 1) {
      System.out.println("피벗과 같은 그룹");
      for (int i = rightPointer + 1; i < leftPointer; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
    }

    System.out.println("피벗 이상의 그룹");
    for (int i = rightPointer + 1; i < num; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
