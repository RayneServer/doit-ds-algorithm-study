package dev.coma.data.sort;

import java.util.Scanner;

public class Quiz09 {
  public static void main(String[] args) {
    int num;
    int[] arr;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("삽입 정렬 Ver.3");
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

      printArr(arr);

      pointer = findMyIndex(arr, i - 1, i);

      for (int j = i; j > pointer; j--) {
        arr[j] = arr[j - 1];
      }

      arr[pointer] = temp;
      printArrMove(arr, pointer, i);
    }
  }

  private static void printArr(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + "   ");
    }

    System.out.println();
  }

  private static int findMyIndex(int[] arr, int lastSortIndex, int moveIndex) {
    if (arr[moveIndex] > arr[lastSortIndex]) return moveIndex;

    int leftPointer = 0;
    int rightPointer = lastSortIndex;
    int midPointer = 0;

    while (leftPointer <= rightPointer) {
      midPointer = (leftPointer + rightPointer) / 2;

      if (arr[midPointer] > arr[moveIndex]) {
        rightPointer = midPointer - 1;
      } else {
        leftPointer = midPointer + 1;
      }
    }

    return arr[midPointer] > arr[moveIndex] ? midPointer : midPointer + 1;
  }

  private static void printArrMove(int[] arr, int insertIndex, int moveIndex) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      if (i == insertIndex) {
        stringBuilder.append(insertIndex == moveIndex ? "+" : "^---");
      }
      else if (i == moveIndex) stringBuilder.append("+");
      else if (i > insertIndex && i < moveIndex) stringBuilder.append("----");
      else stringBuilder.append("    ");
    }

    System.out.println(stringBuilder);
  }
}
