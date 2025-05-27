public class Quiz14 {
  public static void main(String[] args) {
    triangleLB(5);
    System.out.println();

    triangleLU(5);
    System.out.println();

    triangleRU(5);
    System.out.println();

    triangleRB(5);
  }

  static void triangleLB(int num) {
    for (int i = 1; i <= num; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }

      System.out.println();
    }
  }

  static void triangleLU(int num) {
    for (int i = 1; i <= num; i++) {
      for (int j = 1; j <= (num + 1) - i; j++) {
        System.out.print("*");
      }

      System.out.println();
    }
  }

  static void triangleRU(int num) {
    for (int i = 1; i <= num; i++) {
      for (int j = 1; j <= num; j++) {
        if (j < i) System.out.print(" ");
        else System.out.print("*");
      }

      System.out.println();
    }
  }

  static void triangleRB(int num) {
    for (int i = 1; i <= num; i++) {
      for (int j = 1; j <= num; j++) {
        if (j <= (num - i)) System.out.print(" ");
        else System.out.print("*");
      }

      System.out.println();
    }
  }
}
