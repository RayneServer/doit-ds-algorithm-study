package dev.coma.data.sort;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class SortCalendar {
  public static void main(String[] args) {
    GregorianCalendar[] calendars = {
            new GregorianCalendar(2022, Calendar.NOVEMBER, 1),
            new GregorianCalendar(1963, Calendar.OCTOBER, 18),
            new GregorianCalendar(1985, Calendar.APRIL, 5)
    };

    Arrays.sort(calendars);

    for (GregorianCalendar calendar : calendars) {
      System.out.printf("%04d년 %02d월 %02d일\n", calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
    }
  }
}
