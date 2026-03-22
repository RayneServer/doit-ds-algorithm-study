package service.rayne.data.hash.common;

public enum Menu {
  ADD("추가"),
  REMOVE("삭제"),
  SEARCH("검색"),
  PRINT("출력"),
  TERMINATE("종료");

  private final String message;

  Menu(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
