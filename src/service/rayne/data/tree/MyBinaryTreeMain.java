package service.rayne.data.tree;

import java.util.Objects;
import java.util.Scanner;

public class MyBinaryTreeMain {
  private static final Scanner SC = new Scanner(System.in);
  private static final MyBinaryTree<Integer, Data> TREE = new MyBinaryTree<>();

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
    int input = SC.nextInt();

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

    TREE.add(data.getNum(), data);
  }

  private static void remove() {
    System.out.print("삭제할 데이터를 입력하세요: ");
    Integer input = SC.nextInt();

    boolean result = TREE.remove(input);
    if (!result) System.out.println("대상이 없습니다.");
  }

  private static void search() {
    System.out.print("검색할 데이터를 입력하세요: ");
    Integer input = SC.nextInt();

    Data result = TREE.search(input);
    if (Objects.isNull(result)) System.out.println("대상이 없습니다.");
    else System.out.println("그 번호의 이름은 " + result.getName() + "입니다.");
  }

  private static void print() {
    TREE.print();
  }

  private static Data createData() {
    System.out.print("번호: ");
    int num = SC.nextInt();
    SC.nextLine();

    System.out.print("이름: ");
    String name = SC.nextLine();

    return new Data(num, name);
  }
}
