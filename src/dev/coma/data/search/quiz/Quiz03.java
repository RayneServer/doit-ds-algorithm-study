package dev.coma.data.search.quiz;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz03 {
  static int searchIdx(int[] arr, int key, int[] idxArr) {
    int count = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == key) {
        idxArr[count++] = i;
      }
    }

    return count;
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
			int[] idxArr = new int[intArr.length];
			int targetIdxCount = searchIdx(intArr, inputKey, idxArr);

			idxArr = Arrays.copyOf(idxArr, targetIdxCount);
			System.out.println("일치하는 요소의 수는 총 " + targetIdxCount + "개입니다.");
			System.out.println("일치하는 요소의 Index: " + Arrays.toString(idxArr));
		}
  }
}
