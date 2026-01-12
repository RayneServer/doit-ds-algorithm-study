package dev.coma.data.sort;

import java.util.Scanner;

public class Quiz18 {
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
    int min = Integer.MAX_VALUE;
    for (int i : arr) {
      if (max < i) max = i;
      if (min > i) min = i;
    }

    countingSort(arr, min, max);

    System.out.println("오름차순으로 정렬했습니다.");
    for (int i = 0; i < num; i++) {
      System.out.printf("arr[%s] = %s\n", i, arr[i]);
    }
  }

  private static void countingSort(int[] arr, int min, int max) {
    int[] countArr = new int[max - min + 1];
    int[] workArr = new int[arr.length];

    System.out.println("[도수 정렬 실행 전]");
    printArrAll(arr, countArr, workArr);
    System.out.println();

    for (int i = 0; i < arr.length; i++) {
      countArr[arr[i] - min]++;
    }

    System.out.println("[도수분포표 생성]");
    printArrAll(arr, countArr, workArr);
    System.out.println();

    for (int i = 1; i <= max - min; i++) {
      countArr[i] += countArr[i - 1];
    }

    System.out.println("[누적도수분포표 생성]");
    printArrAll(arr, countArr, workArr);
    System.out.println();

    for (int i = arr.length - 1; i >= 0; i--) {
      workArr[--countArr[arr[i] - min]] = arr[i];
    }

    System.out.println("[도수 정렬 실행]");
    printArrAll(arr, countArr, workArr);
    System.out.println();

    for (int i = 0; i < arr.length; i++) {
      arr[i] = workArr[i];
    }

    System.out.println("[기존 배열에 결과 반영]");
    printArrAll(arr, countArr, workArr);
    System.out.println();
  }

  private static void printArrAll(int[] arr, int[] countArr, int[] workArr) {
    System.out.println("= 기존 배열 =");
    printArr(arr);

    System.out.println("= 도수 배열 =");
    printArr(countArr);

    System.out.println("= 작업 배열 =");
    printArr(workArr);
  }

  private static void printArr(int[] arr) {
    StringBuilder stringBuilder = new StringBuilder("[");
    for (int i : arr) {
      stringBuilder.append(i + ", ");
    }

    stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");
    stringBuilder.append("]");

    System.out.println(stringBuilder);
  }
}
