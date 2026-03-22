package service.rayne.data.list.doublelinked;

import java.util.Objects;
import java.util.Scanner;

public class MyDoubleLinkedListMain {
  private static final Scanner SC = new Scanner(System.in);
  private static final MyDoubleLinkedList<Data> DATA_LIST = new MyDoubleLinkedList<>();

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
      case ADD_FIRST -> addFirst();
      case ADD_LAST -> addLast();
      case RMV_FIRST -> removeFirst();
      case RMV_LAST -> removeLast();
      case RMV_DATA -> remove();
      case SEARCH -> search();
      case CLEAR -> clear();
      case SIZE -> size();
      case PURGE -> purge();
      case RETRIEVE -> retrieve();
      case PRINT_ALL -> printAll();
    }
  }

  private static void addFirst() {
    System.out.println("머리에 추가할 데이터를 입력하세요.");
    DATA_LIST.addFirst(createData());
  }

  private static void addLast() {
    System.out.println("꼬리에 추가할 데이터를 입력하세요.");
    DATA_LIST.addLast(createData());
  }

  private static void removeFirst() {
    DATA_LIST.removeFirst();
  }

  private static void removeLast() {
    DATA_LIST.removeLast();
  }

  private static void remove() {
    System.out.println("삭제할 번호를 입력하세요.");
    System.out.print("번호: ");
    int num = SC.nextInt();

    DATA_LIST.remove(new Data(num, null));
  }

  private static void search() {
    System.out.println("검색할 번호를 입력하세요.");
    System.out.print("번호: ");
    int num = SC.nextInt();

    Data data = DATA_LIST.search(new Data(num, null));
    System.out.println(Objects.isNull(data) ? "데이터가 없습니다." : "검색 성공: " + data);
  }

  private static void clear() {
    DATA_LIST.clear();
  }

  private static void size() {
    System.out.println("현재 크기: " + DATA_LIST.size());
  }

  private static void purge() {
    DATA_LIST.purge();
  }

  private static void retrieve() {
    System.out.print("숫자를 입력해주세요: ");
    int count = SC.nextInt();

    Data result = DATA_LIST.retrieve(count);
    System.out.println(Objects.isNull(result) ? "입력한 숫자가 리스트 크기보다 큽니다." : count + "번째 데이터 = " + result);
  }

  private static void printAll() {
    System.out.println(DATA_LIST);
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
