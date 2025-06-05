import java.util.Scanner;

public class Quiz06 {
  static void recur3(int n) {
    if (n > 0) {
      recur3(n - 1);
      recur3(n - 2);
      System.out.println(n);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("정수를 입력하세요: ");
    int num = scanner.nextInt();

    recur3(num);
  }
}
