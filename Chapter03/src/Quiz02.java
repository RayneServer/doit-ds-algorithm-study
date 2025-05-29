import java.util.Scanner;

public class Quiz02 {
  static int seqSearch(int[] arr, int key) {
    System.out.print("   |");
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("%3d", i);
    }
    System.out.print("\n---+");
    System.out.println("---".repeat(arr.length));

    for (int i = 0; i < arr.length; i++) {
      System.out.print("   |");
      for (int j = 0; j <= i; j++) {
        if (j == i) System.out.print("  *");
        else System.out.print("   ");
      }
      System.out.print("\n  " + i + "|");
      for (int j = 0; j < arr.length; j++) {
        System.out.printf("%3d", arr[j]);
      }
      System.out.println();

      if (arr[i] == key) return i;

      System.out.println("   |");
    }

    return -1;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("요소의 수: ");
    int[] intArr = new int[scanner.nextInt()];

    for (int i = 0; i < intArr.length; i++) {
      System.out.print("arr[" + i + "]: ");
      intArr[i] = scanner.nextInt();
    }

    System.out.print("검색할 요소의 값: ");
    int inputKey = scanner.nextInt();
    int targetIdx = seqSearch(intArr, inputKey);

    System.out.println(targetIdx == -1 ? "해당하는 값의 요소가 없습니다." : "해당하는 값의 요소는 arr[" + targetIdx + "]에 있습니다.");
  }
}