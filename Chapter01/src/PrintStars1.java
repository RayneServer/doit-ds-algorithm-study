import java.util.Scanner;

public class PrintStars1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("*을 n개 출력합니다.\nw개마다 줄을 바꿉니다.");

    int inputN, inputW;
    do {
      System.out.print("n의 값: ");
      inputN = scanner.nextInt();
    } while (inputN <= 0);

    do {
      System.out.print("w의 값: ");
      inputW = scanner.nextInt();
    } while (inputW <= 0 || inputW > inputN);

    for (int i = 0; i < inputN; i++) {
      System.out.print("*");

      if (i % inputW == inputW - 1) System.out.println();
    }
    if (inputN % inputW != 0) System.out.println();
  }
}
