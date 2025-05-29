import java.util.Arrays;
import java.util.Scanner;

public class Quiz06 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("요소의 수: ");
    int[] intArr = new int[scanner.nextInt()];

    for (int i = 0; i < intArr.length; i++) {
      System.out.print("arr[" + i + "]: ");
      intArr[i] = scanner.nextInt();
    }

    Arrays.sort(intArr);
    System.out.println("정렬된 배열: " + Arrays.toString(intArr));

    System.out.print("검색할 요소의 값: ");
    int inputKey = scanner.nextInt();

    int targetIdx = Arrays.binarySearch(intArr, inputKey);

    System.out.println(targetIdx < 0 ? "해당하는 값의 요소가 없습니다. 삽입 포인트는 " + ((-targetIdx) - 1) + "입니다." : "해당하는 값의 요소는 arr[" + targetIdx + "]에 있습니다.");
  }
}
