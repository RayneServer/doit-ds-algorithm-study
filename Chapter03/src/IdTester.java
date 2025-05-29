class Id {
  private static int counter = 0;

  private int id;

  public Id() {
    id = counter++;
  }

  public static int getCounter() {
    return counter;
  }

  public int getId() {
    return id;
  }
}

public class IdTester {
  public static void main(String[] args) {
    Id student01 = new Id();
    Id student02 = new Id();

    System.out.println("student01의 아이디: " + student01.getId());
    System.out.println("student02의 아이디: " + student02.getId());

    System.out.println("부여한 아이디 개수: " + Id.getCounter());
  }
}
