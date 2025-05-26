public class Quiz08 {
  public static void main(String[] args) {
    System.out.println("sumOf(3, 5) = " + sumOf(3, 5));
    System.out.println("sumOf(6, 4) = " + sumOf(6, 4));
  }

  static int sumOf(int a, int b) {
    int sum = 0;
    for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
      sum += i;
    }

    return sum;
  }
}
