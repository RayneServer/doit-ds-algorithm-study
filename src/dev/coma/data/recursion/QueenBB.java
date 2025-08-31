package dev.coma.data.recursion;

public class QueenBB {
  static boolean[] queenFlag = new boolean[8];
  static int[] position = new int[8];

  static void print() {
    for (int i = 0; i < 8; i++) {
      System.out.printf("%2d", position[i]);
    }

    System.out.println();
  }

  static void set(int i) {
    for (int j = 0; j < 8; j++) {
      if (queenFlag[j] == false) {
        position[i] = j;

        if (i == 7) print();
        else {
          queenFlag[j] = true;
          set(i + 1);
          queenFlag[j] = false;
        }
      }
    }
  }

  public static void main(String[] args) {
    set(0);
  }
}
