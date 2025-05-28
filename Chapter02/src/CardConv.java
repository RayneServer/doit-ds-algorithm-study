import java.util.Scanner;

public class CardConv {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("10진수를 기수 변환합니다.");
    while (true) {
      int inputNum;
      do {
        System.out.print("음이 아닌 정수: ");
        inputNum = scanner.nextInt();
      } while (inputNum < 0);

      int inputDigit;
      do {
        System.out.print("변환할 진수: ");
        inputDigit = scanner.nextInt();
      } while (inputDigit < 2 || inputDigit > 36);

      char[] resultArr = new char[32];
      int result = cardConv(inputNum, inputDigit, resultArr);

      System.out.print(inputDigit + "진수로 ");
      for (int i = 0; i < result; i++) {
        System.out.print(resultArr[i]);
      }
      System.out.println("입니다.");

      System.out.print("한 번 더 할까요? (1: 예 / 2: 아니오): ");
      if (scanner.nextInt() == 2) break;
    }
  }

  static int cardConv(int inputNum, int digit, char[] charArr) {
    int result = 0;
    String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    do {
      charArr[result++] = dchar.charAt(inputNum % digit);
      inputNum /= digit;
    } while (inputNum != 0);

    for (int i = 0; i < (result / 2); i++) {
      char t = charArr[i];
      charArr[i] = charArr[(result - 1) - i];
      charArr[(result - 1) - i] = t;
    }

    return result;
  }
}
