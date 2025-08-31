package dev.coma.data.basic.algorithm.quiz;

public class Quiz02 {
  public static void main(String[] args) {
    System.out.println("min3(1, 2, 3) = " + min3(1, 2, 3));
    System.out.println("min3(1, 3, 2) = " + min3(1, 3, 2));
    System.out.println("min3(2, 1, 3) = " + min3(2, 1, 3));
    System.out.println("min3(2, 3, 1) = " + min3(2, 3, 1));
    System.out.println("min3(3, 1, 2) = " + min3(3, 1, 2));
    System.out.println("min3(3, 2, 1) = " + min3(3, 2, 1));
  }

  static int min3(int a, int b, int c) {
    int min = a;
    if (b < min) min = b;
    if (c < min) min = c;

    return min;
  }
}
