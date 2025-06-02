import java.util.Scanner;

public class IntQueueTester {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    IntQueue queue = new IntQueue(64);

    while (true) {
      System.out.println();
      System.out.printf("현재 데이터 개수: %d / %d\n", queue.size(), queue.getCapacity());
      System.out.println("[1] 인큐  [2] 디큐  [3] 피크  [4] 덤프  [0] 종료");
      System.out.print("선택: ");

      int menu = scanner.nextInt();
      if (menu == 0) break;

      int number;
      switch (menu) {
        case 1 -> {
          System.out.print("데이터: ");
          number = scanner.nextInt();

          try {
            queue.enque(number);
          } catch (IntQueue.OverflowIntQueueException e) {
            System.out.println("큐가 가득 찼습니다.");
          }
        }

        case 2 -> {
          try {
            number = queue.deque();
            System.out.println("Deque한 데이터는 " + number + "입니다.");
          } catch (IntQueue.EmptyIntQueueException e) {
            System.out.println("큐가 비어 있습니다.");
          }
        }

        case 3 -> {
          try {
            number = queue.peek();
            System.out.println("Peek한 데이터는 " + number + "입니다.");
          } catch (IntQueue.EmptyIntQueueException e) {
            System.out.println("큐가 비어 있습니다.");
          }
        }

        case 4 -> queue.dump();

        default -> {}
      }
    }
  }
}
