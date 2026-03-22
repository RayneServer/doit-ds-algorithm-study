package service.rayne.data.hash.chain;

import service.rayne.data.hash.common.Data;
import service.rayne.data.hash.common.Menu;

import java.util.Objects;
import java.util.Scanner;

public class ChainHashMain {
  private static final Scanner SCANNER = new Scanner(System.in);
  private static final ChainHash<Integer, Data> HASH = new ChainHash<>(13);

  public static void main(String[] args) {
    while (true) {
      Menu menu = selectMenu();

      if (menu == Menu.TERMINATE) {
        System.out.println("프로그램을 종료합니다.");
        return;
      }

      if (menu == null) {
        System.out.println("올바른 번호를 입력해주세요.\n");
        continue;
      }

      activeMenu(menu);
    }
  }

  private static Menu selectMenu() {
    for (Menu menu : Menu.values()) {
      if (menu.ordinal() != 0 && menu.ordinal() % 3 == 0) System.out.println();

      System.out.printf("(%d) %s ", menu.ordinal(), menu.getMessage());
    }

    System.out.print("\n메뉴를 선택하세요: ");
    int input = SCANNER.nextInt();

    for (Menu menu : Menu.values()) {
      if (menu.ordinal() == input) return menu;
    }

    return null;
  }

  private static void activeMenu(Menu menu) {
    switch (menu) {
      case ADD -> add();
      case REMOVE -> remove();
      case SEARCH -> search();
      case PRINT -> print();
    }
  }

  private static void add() {
    Data data = createData();

    HASH.add(data.getNum(), data);
  }

  private static void remove() {
    System.out.print("삭제할 데이터를 입력하세요: ");
    Integer input = SCANNER.nextInt();

    boolean result = HASH.remove(input);
    if (!result) System.out.println("대상이 없습니다.");
  }

  private static void search() {
    System.out.print("검색할 데이터를 입력하세요: ");
    Integer input = SCANNER.nextInt();

    Data result = HASH.search(input);
    if (Objects.isNull(result)) System.out.println("대상이 없습니다.");
    else System.out.println("그 번호의 이름은 " + result.getName() + "입니다.");
  }

  private static void print() {
    HASH.print();
  }

  private static Data createData() {
    System.out.print("번호: ");
    int num = SCANNER.nextInt();
    SCANNER.nextLine();

    System.out.print("이름: ");
    String name = SCANNER.nextLine();

    return new Data(num, name);
  }
}
