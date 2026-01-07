package dev.coma.data.sort;

import java.util.Scanner;

public class Quiz10 {
  private static int moveCount;

  public static void main(String[] args) {
    int num;
    int[] arr;

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Shell 정렬 Ver.2+");
      System.out.print("요소수: ");
      num = scanner.nextInt();

      arr = new int[num];
      for (int i = 0; i < num; i++) {
        System.out.printf("arr[%s]:", i);
        arr[i] = scanner.nextInt();
      }
    }

    shellSort(arr, num);

    System.out.println("오름차순으로 정렬했습니다.");
    for (int i = 0; i < num; i++) {
      System.out.printf("arr[%s] = %s\n", i, arr[i]);
    }

    System.out.printf("이동을 %s회 했습니다.\n", moveCount);
  }

  private static void shellSort(int[] arr, int num) {
    int h = 1;
    while (h < num) h = h * 3 + 1;

    while (h > 0) {
      for (int i = h; i < num; i++) {
        int pointer;
        int temp = arr[i];

        for (pointer = i - h; pointer >= 0 && arr[pointer] > temp; pointer -= h) {
          arr[pointer + h] = arr[pointer];
          System.out.printf("%s를 %s로 이동\n", pointer, pointer + h);
          moveCount++;
        }

        arr[pointer + h] = temp;
      }

      h /= 3;
    }
  }
}
