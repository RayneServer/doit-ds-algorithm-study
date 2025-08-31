package dev.coma.data.basic.algorithm.quiz;

public class Quiz16 {
  public static void main(String[] args) {
    npira(12);
  }

  static void npira(int num) {
    for (int i = 1; i <= num; i++) {
      for (int j = 1; j <= (num - i); j++) {
        System.out.print(" ");
      }

      for (int j = 1; j <= (2 * i) - 1; j++) {
        System.out.print(i % 10);
      }

      System.out.println();
    }
  }
}
