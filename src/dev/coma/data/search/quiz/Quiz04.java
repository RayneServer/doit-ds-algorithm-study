package dev.coma.data.search.quiz;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz04 {
  static int binarySearch(int[] arr, int key) {
    int startIdx = 0;
    int endIdx = arr.length - 1;

    System.out.print("   |");
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("%3d", i);
    }
    System.out.print("\n---+");
    System.out.println("---".repeat(arr.length));

    do {
      int midIdx = (startIdx + endIdx) / 2;

      System.out.print("   |");
      for (int j = 0; j <= arr.length; j++) {
        if (j == startIdx) System.out.print("<- ");
        else if (j == midIdx) System.out.print("  +");
        else if (j == endIdx) System.out.print(" ->");
        else System.out.print("   ");
      }
      System.out.print("\n  " + midIdx + "|");
      for (int j = 0; j < arr.length; j++) {
        System.out.printf("%3d", arr[j]);
      }
      System.out.println();

      if (arr[midIdx] == key) return midIdx;
      else if (arr[midIdx] < key) startIdx = midIdx + 1;
      else endIdx = midIdx - 1;

      System.out.println("   |");
    } while (startIdx <= endIdx);

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

			Arrays.sort(intArr);
			System.out.println("정렬된 배열: " + Arrays.toString(intArr));

			System.out.print("검색할 요소의 값: ");
			int inputKey = scanner.nextInt();
			int targetIdx = binarySearch(intArr, inputKey);

			System.out.println(targetIdx == -1 ? "해당하는 값의 요소가 없습니다." : "해당하는 값의 요소는 arr[" + targetIdx + "]에 있습니다.");
		}
  }
}
