package dev.coma.data.recursion.quiz;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Quiz08 {
  static class Frame {
    int plateNum;
    int startPill;
    int targetPill;
    int step;

    Frame(int plateNum, int startPill, int targetPill, int step) {
      this.plateNum = plateNum;
      this.startPill = startPill;
      this.targetPill = targetPill;
      this.step = step;
    }
  }

  static void move(int plateNum, int startPill, int targetPill) {
    Deque<Frame> stack = new ArrayDeque<>();
    stack.push(new Frame(plateNum, startPill, targetPill, 0));

    while (!stack.isEmpty()) {
      Frame frame = stack.pop();

      if (frame.plateNum <= 1) {
        System.out.printf("원반[%d]을(를) %d번 기둥에서 %d번 기둥으로 옮김\n", frame.plateNum, frame.startPill, frame.targetPill);
        continue;
      }

      if (frame.step == 0) {
        stack.push(new Frame(frame.plateNum, frame.startPill, frame.targetPill, 1));
        stack.push(new Frame(frame.plateNum - 1, frame.startPill, 6 - frame.startPill - frame.targetPill, 0));
      } else {
        System.out.printf("원반[%d]을(를) %d번 기둥에서 %d번 기둥으로 옮김\n", frame.plateNum, frame.startPill, frame.targetPill);
        stack.push(new Frame(frame.plateNum - 1, 6 - frame.startPill - frame.targetPill, frame.targetPill, 0));
      }
    }
  }

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("하노이의 탑");
			System.out.print("원반의 개수: ");
			int num = scanner.nextInt();

			move(num, 1, 3);
		}
  }
}
