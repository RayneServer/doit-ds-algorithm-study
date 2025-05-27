public class IntArray {
  public static void main(String[] args) {
    int[] arr = new int[5];

    arr[1] = 37;
    arr[2] = 51;
    arr[4] = arr[1] * 2;

    for (int i = 0; i < arr.length; i++) {
      System.out.println("arr[" + i + "] = " + arr[i]);
    }
  }
}
