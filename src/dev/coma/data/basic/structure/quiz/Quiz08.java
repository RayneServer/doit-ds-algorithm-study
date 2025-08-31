package dev.coma.data.basic.structure.quiz;

public class Quiz08 {
  static class YMD {
    int year;
    int month;
    int day;

    YMD(int year, int month, int day) {
      this.year = year;
      this.month = month;
      this.day = day;
    }

    YMD after(int n) {
      int day = this.day + n;
      int month = this.month;
      int year = this.year;

      if (day > 31) {
        month++;
        day -= 31;
      }

      if (month > 12) {
        year++;
        month -= 12;
      }

      return new YMD(year, month, day);
    }

    YMD before(int n) {
      int day = this.day - n;
      int month = this.month;
      int year = this.year;

      if (day < 1) {
        month--;
        day += 31;
      }

      if (month < 1) {
        year--;
        month += 12;
      }

      return new YMD(year, month, day);
    }
  }

  public static void main(String[] args) {
    YMD ymd = new YMD(2025, 5, 2);
    System.out.println(ymd.year);
    System.out.println(ymd.month);
    System.out.println(ymd.day);

    YMD ymd1 = ymd.after(30);
    System.out.println(ymd1.year);
    System.out.println(ymd1.month);
    System.out.println(ymd1.day);

    YMD ymd2 = ymd.before(30);
    System.out.println(ymd2.year);
    System.out.println(ymd2.month);
    System.out.println(ymd2.day);
  }
}
