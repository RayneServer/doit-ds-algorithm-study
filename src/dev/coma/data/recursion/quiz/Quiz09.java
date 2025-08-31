package dev.coma.data.recursion.quiz;

public class Quiz09 {
  static boolean[] rowFlag = new boolean[8];
  static boolean[] leftFlag = new boolean[15];
  static boolean[] rightFlag = new boolean[15];
  static int[] position = new int[8];

  static void print() {
    int[] arr = new int[8];
    for (int i = 0; i < arr.length; i++) {
      arr[position[i]] = i;
    }

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (arr[i] == j) System.out.print("■");
        else System.out.print("□");
      }

      System.out.println();
    }

    System.out.println();
  }

  static void set(int i) {
    for (int j = 0; j < 8; j++) {
      if (rowFlag[j] == false && rightFlag[i + j] == false && leftFlag[j - i + 7] == false) {
        position[i] = j;

        if (i == 7) print();
        else {
          rowFlag[j] = rightFlag[i + j] = leftFlag[j - i + 7] = true;
          set(i + 1);
          rowFlag[j] = rightFlag[i + j] = leftFlag[j - i + 7] = false;
        }
      }
    }
  }

  public static void main(String[] args) {
    set(0);
  }
}
