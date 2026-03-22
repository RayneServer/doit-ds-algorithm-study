package service.rayne.data.list.doublelinked;

public class MyDoubleLinkedList<E extends Comparable<E>> {
  private Node<E> startDummyNode;
  private int size;

  private static class Node<E> {
    private E data;
    private Node<E> prevNode;
    private Node<E> nextNode;

    public Node() {
      data = null;
      prevNode = this;
      nextNode = this;
    }

    public Node(E data, Node<E> prevNode, Node<E> nextNode) {
      this.data = data;
      this.prevNode = prevNode;
      this.nextNode = nextNode;
    }

    @Override
    public String toString() {
      return data.toString();
    }
  }

  public MyDoubleLinkedList() {
    startDummyNode = new Node<>();
    size = 0;
  }

  public void addFirst(E e) {
    Node<E> node = new Node<>(e, startDummyNode, startDummyNode.nextNode);
    startDummyNode.nextNode = node;
    startDummyNode.nextNode.nextNode.prevNode = node;

    size++;
  }

  public void addLast(E e) {
    Node<E> node = new Node<>(e, startDummyNode.prevNode, startDummyNode);
    startDummyNode.prevNode = node;
    startDummyNode.prevNode.prevNode.nextNode = node;

    size++;
  }

  public void removeFirst() {
    if (size == 1) {
      clear();
      return;
    }

    startDummyNode.nextNode.nextNode.prevNode = startDummyNode;
    startDummyNode.nextNode = startDummyNode.nextNode.nextNode;
    size--;
  }

  public void removeLast() {
    if (size == 1) {
      clear();
      return;
    }

    startDummyNode.prevNode.prevNode.nextNode = startDummyNode;
    startDummyNode.prevNode = startDummyNode.prevNode.prevNode;
    size--;
  }

  public void remove(E e) {
    Node<E> pointNode = startDummyNode.nextNode;

    while (pointNode != startDummyNode) {
      if (pointNode.data.compareTo(e) == 0) {
        pointNode.prevNode.nextNode = pointNode.nextNode;
        pointNode.nextNode.prevNode = pointNode.prevNode;
        size--;
        return;
      }

      pointNode = pointNode.nextNode;
    }

    System.out.println("대상이 없습니다.");
  }

  public E search(E e) {
    Node<E> pointNode = startDummyNode.nextNode;

    while (pointNode != startDummyNode) {
      if (pointNode.data.compareTo(e) == 0) return pointNode.data;

      pointNode = pointNode.nextNode;
    }

    return null;
  }

  public void clear() {
    startDummyNode.nextNode = startDummyNode;
    startDummyNode.prevNode = startDummyNode;
    size = 0;
  }

  public int size() {
    return size;
  }

  public void purge() {
    Node<E> pointNode = startDummyNode.nextNode;

    while (pointNode.nextNode != startDummyNode) {
      Node<E> compareNode = pointNode.nextNode;

      while (compareNode != startDummyNode) {
        if (compareNode.data.compareTo(pointNode.data) == 0) {
          compareNode.prevNode.nextNode = compareNode.nextNode;
          compareNode.nextNode.prevNode = compareNode.prevNode;
          size--;
        }

        compareNode = compareNode.nextNode;
      }

      pointNode = pointNode.nextNode;
    }
  }

  public E retrieve(int count) {
    if (count > size) {
      System.out.println("입력한 숫자가 리스트의 크기보다 큽니다.");
      return null;
    }

    int counter = 1;
    Node<E> pointNode = startDummyNode.nextNode;
    while (counter < count) {
      pointNode = pointNode.nextNode;
      counter++;
    }

    return pointNode.data;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");

    if (size != 0) {
      Node<E> pointNode = startDummyNode.nextNode;

      while (pointNode != startDummyNode) {
        stringBuilder.append(pointNode + ", ");
        pointNode = pointNode.nextNode;
      }

      stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");
    }

    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}
