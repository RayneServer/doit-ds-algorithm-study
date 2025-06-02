import java.util.Scanner;

public class Quiz01 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    IntStack stack = new IntStack(64);

    while (true) {
      System.out.println();
      System.out.printf("현재 데이터 개수: %d / %d\n", stack.size(), stack.getCapacity());
      System.out.println("[1] 푸시  [2] 팝  [3] 피크  [4] 덤프  [5] 클리어 ");
      System.out.println("[6] 찾기  [7] 비어있나요?  [8] 꽉 찼나요?  [0] 종료");
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

        case 5 -> stack.clear();

        case 6 -> {
          System.out.print("찾는 데이터: ");
          number = scanner.nextInt();

          System.out.println(stack.indexOf(number) == -1 ? "찾는 데이터가 없습니다." : "찾는 데이터의 index는 " + stack.indexOf(number) + "입니다.");
        }

        case 7 -> {
          if (stack.isEmpty()) System.out.println("스택이 비었습니다.");
          else System.out.println("스택이 비어있지 않습니다.");
        }

        case 8 -> {
          if (stack.isFull()) System.out.println("스택이 꽉 찼습니다.");
          else System.out.println("스택에 여유가 있습니다.");
        }

        default -> {}
      }
    }
  }
}
