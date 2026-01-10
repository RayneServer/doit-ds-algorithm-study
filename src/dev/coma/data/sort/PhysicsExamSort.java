package dev.coma.data.sort;

import java.util.Arrays;
import java.util.Comparator;

public class PhysicsExamSort {
  private static class PhysicData {
    private String name;
    private int height;
    private double vision;

    public PhysicData(String name, int height, double vision) {
      this.name = name;
      this.height = height;
      this.vision = vision;
    }

    @Override
    public String toString() {
      return name + " " + height + " " + vision;
    }
  }

  public static void main(String[] args) {
    PhysicData[] data = {
            new PhysicData("정유니", 162, 0.3),
            new PhysicData("정후야", 173, 0.7),
            new PhysicData("정히나", 175, 2.0),
            new PhysicData("정리제", 171, 1.5),
            new PhysicData("정나나", 168, 0.4),
            new PhysicData("정리코", 174, 1.2),
            new PhysicData("정도현", 169, 0.8)
    };

    Arrays.sort(data, new Comparator<PhysicData>() {
      @Override
      public int compare(PhysicData o1, PhysicData o2) {
        return Integer.compare(o1.height, o2.height);
      }
    });

    System.out.println("[신체검사 리스트]");
    System.out.println("이름       키   시력");
    System.out.println("--------------------");
    for (PhysicData datum : data) {
      System.out.printf("%-8s%3d%5.1f\n", datum.name, datum.height, datum.vision);
    }
  }
}
