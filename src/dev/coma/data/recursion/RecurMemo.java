package dev.coma.data.recursion;

import java.util.Scanner;

public class RecurMemo {
  static String[] memo;

  static void recur(int n) {
    if (memo[n + 1] != null) System.out.print(memo[n + 1]);
    else {
      if (n > 0) {
        recur(n - 1);
        System.out.println(n);
        recur(n - 2);

        memo[n + 1] = memo[n] + n + "\n" + memo[n - 1];
      } else {
        memo[n + 1] = "";
      }
    }
  }

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("정수를 입력하세요: ");
			int num = scanner.nextInt();

			memo = new String[num + 2];
			recur(num);
		}
  }
}
