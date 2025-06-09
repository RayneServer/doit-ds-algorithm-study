public class EightQueen {
  static boolean[] rowFlag = new boolean[8];
  static boolean[] leftFlag = new boolean[15];
  static boolean[] rightFlag = new boolean[15];
  static int[] position = new int[8];

  static void print() {
    for (int i = 0; i < 8; i++) {
      System.out.printf("%2d", position[i]);
    }

    System.out.println();
  }

  static void set(int i) {
    for (int j = 0; j < 8; j++) {
      if (rowFlag[j] == false && rightFlag[i + j] == false && leftFlag[j - i + 7] == false) {
        position[i] = j;

        if (i == 7) print();
        else {
          rowFlag[j] = rightFlag[i + j] = leftFlag[j - i + 7] = true;
          set(i + 1);
          rowFlag[j] = rightFlag[i + j] = leftFlag[j - i + 7] = false;
        }
      }
    }
  }

  public static void main(String[] args) {
    set(0);
  }
}
