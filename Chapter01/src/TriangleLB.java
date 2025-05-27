import java.util.Scanner;

public class TriangleLB {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("왼쪽 아래가 직각인 이등변삼각형 출력하기");

    int inputN;
    do {
      System.out.print("삼각형의 단 수: ");
      inputN = scanner.nextInt();
    } while (inputN <= 0);

    for (int i = 1; i <= inputN; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }

      System.out.println();
    }
  }
}
