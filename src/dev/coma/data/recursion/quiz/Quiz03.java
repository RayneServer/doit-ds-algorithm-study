package dev.coma.data.recursion.quiz;

public class Quiz03 {
  static int gcd(int x, int y) {
    if (y == 0) return x;
    else return gcd(y, x % y);
  }

  static int gcdArray(int[] arr) {
    int result = arr[0];
    for (int i = 1; i < arr.length; i++) {
      result = gcd(result, arr[i]);
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println("여러 정수의 최대공약수 구하기");
    int[] arr = new int[] {48, 72, 108, 96};

    System.out.println("정수들의 최대공약수는 " + gcdArray(arr) + "입니다.");
  }
}
