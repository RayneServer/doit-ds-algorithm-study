import java.util.Scanner;

public class Alternative1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int inputNum;
    System.out.println("+와 -를 번갈아 n개 출력하기");
    do {
      System.out.print("n의 값: ");
      inputNum = scanner.nextInt();
    } while (inputNum <= 0);

    for (int i = 0; i < inputNum; i++) {
      if (i % 2 == 0) System.out.print("+");
      else System.out.print("-");
    }
  }
}
