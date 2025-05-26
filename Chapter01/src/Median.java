import java.util.Scanner;

public class Median {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("세 정수의 중앙값 구하기");

    System.out.print("a의 값: ");
    int inputA = scanner.nextInt();

    System.out.print("b의 값: ");
    int inputB = scanner.nextInt();

    System.out.print("c의 값: ");
    int inputC = scanner.nextInt();

    System.out.printf("중앙값은 %d입니다.", med3(inputA, inputB, inputC));
  }

  static int med3(int a, int b, int c) {
    if (a >= b) {
      if (b >= c) {
        return b;
      } else if (a <= c) {
        return a;
      } else {
        return c;
      }
    } else if (a > c) {
      return a;
    } else if (b > c) {
      return c;
    } else {
      return b;
    }
  }
}
