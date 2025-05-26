import java.util.Scanner;

public class Quiz10 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("양의 정수를 입력하세요: ");
    int number = scanner.nextInt();

    int count = 0;
    while (number != 0) {
      number /= 10;
      count++;
    }

    System.out.println("그 수는 " + count + "자리입니다.");
  }
}
