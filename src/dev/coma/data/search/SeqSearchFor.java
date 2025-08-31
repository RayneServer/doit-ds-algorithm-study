package dev.coma.data.search;

import java.util.Scanner;

public class SeqSearchFor {
  static int seqSearch(int[] arr, int length, int key) {
    for (int i = 0; i < length; i++) {
      if (arr[i] == key) return i;
    }

    return -1;
  }

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("요소의 수: ");
			int[] intArr = new int[scanner.nextInt()];

			for (int i = 0; i < intArr.length; i++) {
			  System.out.print("arr[" + i + "]: ");
			  intArr[i] = scanner.nextInt();
			}

			System.out.print("검색할 요소의 값: ");
			int inputKey = scanner.nextInt();
			int targetIdx = seqSearch(intArr, intArr.length, inputKey);

			System.out.println(targetIdx == -1 ? "해당하는 값의 요소가 없습니다." : "해당하는 값의 요소는 arr[" + targetIdx + "]에 있습니다.");
		}
  }
}
