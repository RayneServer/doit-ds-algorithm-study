public class Quiz01 {
  public static void main(String[] args) {
    System.out.println("max4(1, 2, 3, 4) = " + max4(1, 2, 3, 4));
    System.out.println("max4(1, 3, 2, 4) = " + max4(1, 3, 2, 4));
    System.out.println("max4(2, 1, 4, 3) = " + max4(2, 1, 4, 3));
    System.out.println("max4(2, 3, 4, 1) = " + max4(2, 3, 4, 1));
    System.out.println("max4(3, 1, 2, 4) = " + max4(3, 1, 2, 4));
    System.out.println("max4(3, 4, 2, 1) = " + max4(3, 4, 2, 1));
    System.out.println("max4(4, 3, 2, 1) = " + max4(4, 3, 2, 1));
    System.out.println("max4(4, 1, 3, 2) = " + max4(4, 1, 3, 2));
  }

  static int max4(int a, int b, int c, int d) {
    int max = a;
    if (b > max) max = b;
    if (c > max) max = c;
    if (d > max) max = d;

    return max;
  }
}
