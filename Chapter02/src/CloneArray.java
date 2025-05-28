import java.util.Arrays;

public class CloneArray {
  public static void main(String[] args) {
    int[] arrA = {1, 2, 3, 4, 5};
    int[] arrB = arrA.clone();

    arrB[3] = 0;

    System.out.println("arrA = " + Arrays.toString(arrA));
    System.out.println("arrB = " + Arrays.toString(arrB));
  }
}
