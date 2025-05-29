import java.util.Arrays;
import java.util.Scanner;

public class StringBinarySearch {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] members = {
            "Kanna", "Yuni",
            "Hina", "Mashiro", "Lize", "Tabi",
            "Shibuki", "Rin", "Nana", "Riko"
    };

    Arrays.sort(members);
    System.out.println("정렬된 멤버 목록: " + Arrays.toString(members));

    System.out.print("찾는 멤버를 입력하세요: ");
    String stella = scanner.nextLine();

    int targetIdx = Arrays.binarySearch(members, stella);

    System.out.println(targetIdx < 0 ? "찾는 멤버가 없습니다." : "찾는 멤버는 arr[" + targetIdx + "]에 있습니다.");
  }
}
