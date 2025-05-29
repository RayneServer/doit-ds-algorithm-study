import java.util.Scanner;

public class Quiz01 {
  static int seqSearchSentinel(int[] arr, int length, int key) {
    int pointer;
    arr[length - 1] = key;

    for (pointer = 0; true; pointer++) {
      if (arr[pointer] == key) break;
    }

    return pointer == (length - 1) ? -1 : pointer;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("요소의 수: ");
    int[] intArr = new int[scanner.nextInt() + 1];

    for (int i = 0; i < intArr.length - 1; i++) {
      System.out.print("arr[" + i + "]: ");
      intArr[i] = scanner.nextInt();
    }

    System.out.print("검색할 요소의 값: ");
    int inputKey = scanner.nextInt();
    int targetIdx = seqSearchSentinel(intArr, intArr.length, inputKey);

    System.out.println(targetIdx == -1 ? "해당하는 값의 요소가 없습니다." : "해당하는 값의 요소는 arr[" + targetIdx + "]에 있습니다.");
  }
}
