package dev.coma.data.list.linked;

public class MyLinkedList<E extends Comparable<E>> {
  private Node<E> head;
  private Node<E> tail;
  private int size;

  private static class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E data) {
      this.data = data;
      this.next = null;
    }

    @Override
    public String toString() {
      return data.toString();
    }
  }

  public MyLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public void addFirst(E e) {
    Node<E> node = head;
    head = new Node<>(e);
    head.next = node;

    if (tail == null) tail = head;

    size++;
  }

  public void addLast(E e) {
    if (head == null) {
      addFirst(e);
      return;
    }

    tail.next = new Node<>(e);
    tail = tail.next;
    size++;
  }

  public void removeFirst() {
    if (head == null) throw new RuntimeException("head is null!");

    head = head.next;
    size--;
  }

  public void removeLast() {
    if (head == null || head.next == null) {
      removeFirst();
      return;
    }

    Node<E> node = head;
    while (node.next.next != null) {
      node = node.next;
    }

    tail = node;
    tail.next = null;
    size--;
  }

  public void remove(E e) {
    if (head == null) throw new RuntimeException("head is null!");

    Node<E> node = head;
    Node<E> prev = null;
    while (node != null) {
      if (node.data.compareTo(e) == 0) break;

      prev = node;
      node = node.next;
    }

    if (node == null) System.out.println("대상이 없습니다.");
    else if (node == head) removeFirst();
    else {
      if (node == tail) tail = prev;

      prev.next = node.next;
      size--;
    }
  }

  public E search(E e) {
    Node<E> node = head;

    while (node != null) {
      if (node.data.compareTo(e) == 0) return node.data;

      node = node.next;
    }

    return null;
  }

  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }

  public int size() {
    return size;
  }

  public void purge() {
    Node<E> node = head;

    while (node.next != null) {
      Node<E> selectNode = node.next;
      Node<E> prevNode = node;

      while (selectNode != null) {
        if (selectNode.data.compareTo(node.data) == 0) {
          prevNode.next = selectNode.next;

          selectNode = selectNode.next;
          size--;
        } else {
          prevNode = selectNode;
          selectNode = selectNode.next;
        }
      }

      node = node.next;
    }
  }

  public E retrieve(int count) {
    if (count > size) return null;

    int counter = 1;
    Node<E> node = head;

    while (counter < count) {
      node = node.next;
      counter++;
    }

    return node.data;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");

    if (head != null) {
      Node<E> node = head;

      while (node != null) {
        stringBuilder.append(node + ", ");
        node = node.next;
      }

      stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");
    }

    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}
