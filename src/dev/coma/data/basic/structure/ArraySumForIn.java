package dev.coma.data.basic.structure;

public class ArraySumForIn {
  public static void main(String[] args) {
    double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};

    for (int i = 0; i < arr.length; i++) {
      System.out.println("arr[" + i + "] = " + arr[i]);
    }

    double sum = 0;
    for (double d : arr) {
      sum += d;
    }

    System.out.println("모든 요소의 합은 " + sum + "입니다.");
  }
}
