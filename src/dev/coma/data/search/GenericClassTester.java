package dev.coma.data.search;

public class GenericClassTester {
  static class GenericClass<T> {
    private T xyz;

    GenericClass(T t) {
      this.xyz = t;
    }

    T getXyz() {
      return xyz;
    }
  }

  public static void main(String[] args) {
    GenericClass<String> str = new GenericClass<>("ABC");
    GenericClass<Integer> i = new GenericClass<>(15);

    System.out.println(str.getXyz());
    System.out.println(i.getXyz());
  }
}
