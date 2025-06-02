import java.util.Scanner;

public class IntStackTester {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    IntStack stack = new IntStack(64);

    while (true) {
      System.out.println();
      System.out.printf("현재 데이터 개수: %d / %d\n", stack.size(), stack.getCapacity());
      System.out.println("[1] 푸시  [2] 팝  [3] 피크  [4] 덤프  [0] 종료");
      System.out.print("선택: ");

      int menu = scanner.nextInt();
      if (menu == 0) break;

      int number;
      switch (menu) {
        case 1 -> {
          System.out.print("데이터: ");
          number = scanner.nextInt();

          try {
            stack.push(number);
          } catch (IntStack.OverflowIntStackException e) {
            System.out.println("스택이 가득 찼습니다.");
          }
        }

        case 2 -> {
          try {
            number = stack.pop();
            System.out.println("Pop한 데이터는 " + number + "입니다.");
          } catch (IntStack.EmptyIntStackException e) {
            System.out.println("스택이 비어 있습니다.");
          }
        }

        case 3 -> {
          try {
            number = stack.peek();
            System.out.println("Peek한 데이터는 " + number + "입니다.");
          } catch (IntStack.EmptyIntStackException e) {
            System.out.println("스택이 비어 있습니다.");
          }
        }

        case 4 -> stack.dump();

        default -> {}
      }
    }
  }
}
