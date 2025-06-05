import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RecurX2 {
  static void recur(int n) {
    Deque<Integer> stack = new ArrayDeque<>();

    while (true) {
      if (n > 0) {
        stack.push(n);
        n = n - 1;
        continue;
      }

      if (!stack.isEmpty()) {
        n = stack.pop();
        System.out.println(n);
        n = n - 2;
        continue;
      }

      break;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("정수를 입력하세요: ");
    int num = scanner.nextInt();

    recur(num);
  }
}
