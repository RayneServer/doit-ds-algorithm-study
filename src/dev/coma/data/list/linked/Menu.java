package dev.coma.data.list.linked;

public enum Menu {
  ADD_FIRST("머리에 노드 추가"),
  ADD_LAST("꼬리에 노드 추가"),
  RMV_FIRST("머리 노드 삭제"),
  RMV_LAST("꼬리 노드 삭제"),
  RMV_DATA("특정 노드 삭제"),
  SEARCH("특정 노드 검색"),
  CLEAR("모든 노드 삭제"),
  SIZE("노드 크기 출력"),
  PURGE("노드 중복 제거"),
  RETRIEVE("n번째 데이터 출력"),
  PRINT_ALL("모든 노드의 데이터 출력"),
  TERMINATE("종료");

  private final String message;

  Menu(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
