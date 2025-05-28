import java.util.Random;

public class Quiz01 {
  public static void main(String[] args) {
    Random random = new Random();

    System.out.println("키의 최대값 구하기");
    int[] height = new int[random.nextInt(6) + 5];
    System.out.println("사람 수: " + height.length);

    System.out.println("키 값은 아래와 같습니다.");
    for (int i = 0; i < height.length; i++) {
      height[i] = 100 + random.nextInt(90);
      System.out.println("height[" + i + "]: " + height[i]);
    }

    System.out.println("최대값은 " + maxOf(height) + "입니다.");
  }

  static int maxOf(int[] a) {
    int max = a[0];
    for (int i = 1; i < a.length; i++) {
      if (a[i] > max) max = a[i];
    }

    return max;
  }
}
