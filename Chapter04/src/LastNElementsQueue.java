import java.util.Scanner;

public class LastNElementsQueue {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    final int N = 10;
    int[] arr = new int[N];
    int pointer = 0;


    System.out.println("정수를 입력하세요.");
    while (true) {
      System.out.printf("%d번째 정수: ", pointer + 1);
      arr[pointer++ % N] = scanner.nextInt();

      System.out.print("계속 입력할까요? (1. 예 / 2. 아니오): ");
      int select = scanner.nextInt();
      if (select == 2) break;
    }

    int i = pointer - N;
    if (i < 0) i = 0;

    for (; i < pointer; i++) {
      System.out.printf("%2d번째 정수: %d\n", i + 1, arr[i % N]);
    }


  }
}
