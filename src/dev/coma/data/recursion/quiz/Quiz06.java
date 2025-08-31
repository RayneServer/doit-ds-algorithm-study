package dev.coma.data.recursion.quiz;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Quiz06 {

  static class Frame {
    int n;
    int step;

    Frame(int n, int step) {
      this.n = n;
      this.step = step;
    }
  }

  static void recur3(int n) {
    Deque<Frame> stack = new ArrayDeque<>();
    stack.push(new Frame(n, 0));

    while (!stack.isEmpty()) {
      Frame frame = stack.pop();

      if (frame.n <= 0) continue;

      if (frame.step == 0) {
        stack.push(new Frame(frame.n, 1));
        stack.push(new Frame(frame.n - 1, 0));
      } else if (frame.step == 1) {
        stack.push(new Frame(frame.n, 2));
        stack.push(new Frame(frame.n - 2, 0));
      } else {
        System.out.println(frame.n);
      }
    }
  }

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("정수를 입력하세요: ");
			int num = scanner.nextInt();

			recur3(num);
		}
  }
}
