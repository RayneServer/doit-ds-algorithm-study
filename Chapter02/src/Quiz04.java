import java.util.Arrays;

public class Quiz04 {
  public static void main(String[] args) {
    int[] arrB = {1, 2, 3, 4, 5};
    int[] arrA = new int[5];

    copy(arrA, arrB);
    System.out.println(Arrays.toString(arrA));
  }

  static void copy(int[] arrA, int[] arrB) {
    for (int i = 0; i < Math.min(arrA.length, arrB.length); i++) {
      arrA[i] = arrB[i];
    }
  }
}
