import java.util.Scanner;

public class SumFor2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int inputNum;
    System.out.println("1부터 n까지의 합 구하기");
    do {
      System.out.print("n의 값: ");
      inputNum = scanner.nextInt();
    } while (inputNum <= 0);

    int sum = 0;
    for (int i = 1; i <= inputNum; i++) {
      sum += i;
    }

    System.out.printf("1부터 %d까지의 합은 %d입니다.\n", inputNum, sum);
  }
}
