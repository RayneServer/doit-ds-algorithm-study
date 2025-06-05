import java.util.Scanner;

public class Hanoi {
  static void move(int plateNum, int startPill, int targetPill) {
    if (plateNum > 1) move(plateNum - 1, startPill, 6 - startPill - targetPill);

    System.out.printf("원반[%d]을(를) %d번 기둥에서 %d번 기둥으로 옮김\n", plateNum, startPill, targetPill);

    if (plateNum > 1) move(plateNum - 1, 6 - startPill - targetPill, targetPill);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("하노이의 탑");
    System.out.print("원반의 개수: ");
    int num = scanner.nextInt();

    move(num, 1, 3);
  }
}
