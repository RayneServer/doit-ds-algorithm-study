package dev.coma.data.basic.structure.quiz;

public class Quiz03 {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    System.out.println(sumOf(arr));
  }

  static int sumOf(int[] arr) {
    int sum = 0;
    for (int i : arr) {
      sum += i;
    }

    return sum;
  }
}
