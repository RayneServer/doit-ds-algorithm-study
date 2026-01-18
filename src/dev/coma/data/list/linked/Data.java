package dev.coma.data.list.linked;

public class Data implements Comparable<Data> {
  private Integer num;
  private String name;

  public Data(Integer num, String name) {
    this.num = num;
    this.name = name;
  }

  public Integer getNum() {
    return num;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "(" + num + ") " + name;
  }

  @Override
  public int compareTo(Data o) {
    return Integer.compare(this.num, o.num);
  }
}
