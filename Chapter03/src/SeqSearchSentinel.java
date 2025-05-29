import java.util.Scanner;

public class SeqSearchSentinel {
  static int seqSearchSentinel(int[] arr, int length, int key) {
    int pointer = 0;
    arr[length - 1] = key; // Sentinel (== key) 삽입

    while (true) {
      if (arr[pointer] == key) break; // pointer가 배열의 길이를 넘었는지는 더 이상 판단하지 않아도 됨 => 수행속도 2배 증가
      pointer++;
    }

    return pointer == (length - 1) ? -1 : pointer; // 찾은 값이 Sentinel이면 발견하지 못한 것으로 판단
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("요소의 수: ");
    int[] intArr = new int[scanner.nextInt() + 1]; // Sentinel이 들어갈 공간을 추가해 생성

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
