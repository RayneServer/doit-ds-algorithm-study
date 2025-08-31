package dev.coma.data.basic.structure;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("요소의 수: ");
			int[] intArr = new int[scanner.nextInt()];

			for (int i = 0; i < intArr.length; i++) {
			  System.out.print("intArr[" + i + "]: ");
			  intArr[i] = scanner.nextInt();
			}

			reverse(intArr);

			System.out.println("요소를 역순으로 정렬했습니다.");
			System.out.println("intArr = " + Arrays.toString(intArr));
		}

  }

  static void swap(int[] arr, int idx1, int idx2) {
    int t = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = t;
  }

  static void reverse(int[] arr) {
    for (int i = 0; i < arr.length / 2; i++) {
      swap(arr, i, (arr.length - 1) - i);
    }
  }
}
