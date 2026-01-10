package dev.coma.data.sort;

public class MergeArray {
  public static void main(String[] args) {
    int[] arrA = {2, 4, 6, 8, 11, 13};
    int[] arrB = {1, 2, 3, 4, 9, 16, 21};
    int[] arrC = new int[13];

    System.out.println("두 배열을 병합");
    merge(arrA, arrB, arrC);

    System.out.println("배열 A와 B를 병합해 C에 저장했습니다.");
    System.out.println("배열 A");
    for (int i = 0; i < arrA.length; i++) {
      System.out.print(arrA[i] + " ");
    }
    System.out.println();

    System.out.println("배열 B");
    for (int i = 0; i < arrB.length; i++) {
      System.out.print(arrB[i] + " ");
    }
    System.out.println();

    System.out.println("배열 C");
    for (int i = 0; i < arrC.length; i++) {
      System.out.print(arrC[i] + " ");
    }
  }

  private static void merge(int[] arrA, int[] arrB, int[] arrC) {
    int pointA = 0;
    int pointB = 0;
    int pointC = 0;

    while (pointA < arrA.length && pointB < arrB.length) {
      arrC[pointC++] = (arrA[pointA] <= arrB[pointB]) ? arrA[pointA++] : arrB[pointB++];
    }

    while (pointA < arrA.length) arrC[pointC++] = arrA[pointA++];
    while (pointB < arrB.length) arrC[pointC++] = arrB[pointB++];
  }
}
