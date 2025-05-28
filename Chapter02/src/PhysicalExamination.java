import java.util.Scanner;

public class PhysicalExamination {
  static final int VMAX = 21;

  static class PhyscData {
    String name;
    int height;
    double vision;

    PhyscData(String name, int height, double vision) {
      this.name = name;
      this.height = height;
      this.vision = vision;
    }
  }

  static double avgHeight(PhyscData[] datArr) {
    double sum = 0;

    for (PhyscData physcData : datArr) {
      sum += physcData.height;
    }

    return sum / datArr.length;
  }

  static void distVision(PhyscData[] datArr, int[] distArr) {
    for (int i = 0; i < datArr.length; i++) {
      if (datArr[i].vision >= 0.0 && datArr[i].vision <= (VMAX / 10.0)) {
        distArr[(int) (datArr[i].vision * 10)]++;
      }
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

    int[] vdist = new int[VMAX];

    System.out.println("= 신체검사 리스트 =");
    System.out.println("이름       키  시력");
    System.out.println("-------------------");

    for (PhyscData physcData : physcDataArr) {
      System.out.printf("%-8s%3d%5.1f\n", physcData.name, physcData.height, physcData.vision);
    }

    System.out.printf("\n평균 키: %5.1fcm\n", avgHeight(physcDataArr));

    distVision(physcDataArr, vdist);
    System.out.println("\n시력 분포");
    for (int i = 0; i < VMAX; i++) {
      System.out.printf("%3.1f ~: %2d명\n", i / 10.0, vdist[i]);
    }
  }
}
