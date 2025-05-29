import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Quiz07 {
  static class PhyscData {
    private String name;
    private int height;
    private double vision;

    public static final Comparator<PhyscData> VISION_REVERSE_ORDER = new VisionOrderComparator();

    public PhyscData(String name, int height, double vision) {
      this.name = name;
      this.height = height;
      this.vision = vision;
    }

    private static class VisionOrderComparator implements Comparator<PhyscData> {
      @Override
      public int compare(PhyscData o1, PhyscData o2) {
        return (o1.vision > o2.vision) ? -1 : (o1.vision < o2.vision) ? 1 : 0;
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

    Arrays.sort(physcDataArr, PhyscData.VISION_REVERSE_ORDER);

    System.out.print("시력이 몇인 사람을 찾고 있나요?: ");
    double vision = scanner.nextDouble();
    int targetIdx = Arrays.binarySearch(physcDataArr, new PhyscData("", 0, vision), PhyscData.VISION_REVERSE_ORDER);

    System.out.println(targetIdx < 0 ? "해당하는 값의 요소가 없습니다." : "해당하는 값의 요소는 arr[" + targetIdx + "]에 있습니다.\n찾은 데이터: " + physcDataArr[targetIdx]);
  }
}
