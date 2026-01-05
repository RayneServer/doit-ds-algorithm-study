package dev.coma.data.sort;

import java.util.Scanner;

public class InsertionSort {
  public static void main(String[] args) {
    int num;
    int[] arr;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("삽입 정렬 Ver.1");
      System.out.print("요소수: ");
      num = scanner.nextInt();

      arr = new int[num];
      for (int i = 0; i < num; i++) {
        System.out.printf("arr[%s]:", i);
        arr[i] = scanner.nextInt();
      }
    }

    insertionSort(arr, num);

    System.out.println("오름차순으로 정렬했습니다.");
    for (int i = 0; i < num; i++) {
      System.out.printf("arr[%s] = %s\n", i, arr[i]);
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
