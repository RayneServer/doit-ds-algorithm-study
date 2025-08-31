package dev.coma.data.recursion.quiz;

import java.util.ArrayDeque;
import java.util.Deque;

public class Quiz10 {
  static boolean[] rowFlag = new boolean[8];
  static boolean[] leftFlag = new boolean[15];
  static boolean[] rightFlag = new boolean[15];
  static int[] position = new int[8];

  static void print() {
    for (int i = 0; i < 8; i++) {
      System.out.printf("%2d", position[i]);
    }

    System.out.println();
  }

  static class Frame {
    int i;
    int start;

    Frame(int i, int start) {
      this.i = i;
      this.start = start;
    }
  }

  static void set(int i) {
    Deque<Frame> stack = new ArrayDeque<>();
    stack.push(new Frame(i, 0));

    while (!stack.isEmpty()) {
      Frame frame = stack.pop();
      if (frame.start != 0) {
        rowFlag[frame.start - 1] = rightFlag[frame.i + frame.start - 1] = leftFlag[frame.start - 1 - frame.i + 7] = false;
      }

      for (int j = frame.start; j < 8; j++) {
        if (rowFlag[j] == false && rightFlag[frame.i + j] == false && leftFlag[j - frame.i + 7] == false) {
          position[frame.i] = j;

          if (frame.i == 7) print();
          else {
            rowFlag[j] = rightFlag[frame.i + j] = leftFlag[j - frame.i + 7] = true;
            stack.push(new Frame(frame.i, j + 1));
            stack.push(new Frame(frame.i + 1, 0));
            break;
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    set(0);
  }
}
