import java.util.Scanner;

public class Factorial {
  static int factorial(int n) {
    if (n > 0) return n * factorial(n - 1);
    else return 1;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("정수를 입력하세요: ");
    int num = scanner.nextInt();

    System.out.println(num + "의 팩토리얼 값은 " + factorial(num) + "입니다.");
  }
}
