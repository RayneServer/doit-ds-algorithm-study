package service.rayne.data.sort;

import java.util.Scanner;

public class CountingSort {
  public static void main(String[] args) {
    int num;
    int[] arr;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("도수 정렬");
      System.out.print("요소수: ");
      num = scanner.nextInt();

      arr = new int[num];
      for (int i = 0; i < num; i++) {
        System.out.printf("arr[%s]:", i);
        arr[i] = scanner.nextInt();
      }
    }

    int max = 0;
    for (int i : arr) {
      if (max < i) max = i;
    }

    countingSort(arr, max);

    System.out.println("오름차순으로 정렬했습니다.");
    for (int i = 0; i < num; i++) {
      System.out.printf("arr[%s] = %s\n", i, arr[i]);
    }
  }

  private static void countingSort(int[] arr, int max) {
    int[] countArr = new int[max + 1];
    int[] workArr = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      countArr[arr[i]]++;
    }

    for (int i = 1; i <= max; i++) {
      countArr[i] += countArr[i - 1];
    }

    for (int i = arr.length - 1; i >= 0; i--) {
      workArr[--countArr[arr[i]]] = arr[i];
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i] = workArr[i];
    }
  }
}
