import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {
  static class PhyscData {
    private String name;
    private int height;
    private double vision;

    public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

    public PhyscData(String name, int height, double vision) {
      this.name = name;
      this.height = height;
      this.vision = vision;
    }

    private static class HeightOrderComparator implements Comparator<PhyscData> {
      @Override
      public int compare(PhyscData o1, PhyscData o2) {
        return (o1.height > o2.height) ? 1 : (o1.height < o2.height) ? -1 : 0;
      }
    }

    @Override
    public String toString() {
      return name + " " + height + " " + vision;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    PhyscData[] physcDataArr = {
            new PhyscData("정윤희", 162, 0.3),
            new PhyscData("정인아", 173, 0.7),
            new PhyscData("정시로", 175, 2.0),
            new PhyscData("정타비", 171, 1.5),
            new PhyscData("정북희", 168, 0.4),
            new PhyscData("정나나", 174, 1.2),
            new PhyscData("정리코", 169, 0.8)
    };

    Arrays.sort(physcDataArr, PhyscData.HEIGHT_ORDER);

    System.out.print("키가 몇 cm인 사람을 찾고 있나요?: ");
    int height = scanner.nextInt();
    int targetIdx = Arrays.binarySearch(physcDataArr, new PhyscData("", height, 0.0), PhyscData.HEIGHT_ORDER);

    System.out.println(targetIdx < 0 ? "해당하는 값의 요소가 없습니다." : "해당하는 값의 요소는 arr[" + targetIdx + "]에 있습니다.\n찾은 데이터: " + physcDataArr[targetIdx]);
  }
}
