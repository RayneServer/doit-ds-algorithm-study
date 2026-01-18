package dev.coma.data.list.array;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class MyArrayLinkedList<E extends Comparable<E>> {
  private Node<E>[] nodeArr;
  private Queue<Integer> deletedIndexQueue;
  private Integer head;
  private Integer tail;
  private int size;

  private static class Node<E> {
    private E data;
    private Integer next;

    public void set(E data, Integer next) {
      this.data = data;
      this.next = next;
    }

    @Override
    public String toString() {
      return data.toString();
    }
  }

  public MyArrayLinkedList(int capacity) {
    nodeArr = new Node[capacity];
    deletedIndexQueue = new ArrayDeque<>();
    head = tail = null;
    size = 0;

    for (int i = 0; i < nodeArr.length; i++) {
      nodeArr[i] = new Node<>();
    }
  }

  public void addFirst(E e) {
    if (nodeArr.length <= size) {
      System.out.println("공간이 없습니다.");
      return;
    }

    int insertIdx = getInsertIndex();
    nodeArr[insertIdx].set(e, head);
    head = insertIdx;

    if (Objects.isNull(tail)) tail = head;

    size++;
  }

  public void addLast(E e) {
    if (nodeArr.length <= size) {
      System.out.println("공간이 없습니다.");
      return;
    }

    if (head == null) {
      addFirst(e);
      return;
    }

    int insertIdx = getInsertIndex();
    nodeArr[tail].next = insertIdx;
    nodeArr[insertIdx].set(e, null);
    tail = insertIdx;

    size++;
  }

  private int getInsertIndex() {
    if (!deletedIndexQueue.isEmpty()) {
      return deletedIndexQueue.poll();
    }

    return size;
  }

  public void removeFirst() {
    if (head == null) throw new RuntimeException("head is null!");

    int removeIndex = head;
    head = nodeArr[head].next;
    nodeArr[removeIndex] = new Node<>();
    deletedIndexQueue.offer(removeIndex);

    size--;
  }

  public void removeLast() {
    if (head == null || nodeArr[head].next == null) {
      removeFirst();
      return;
    }

    int beforeTailIndex = head;
    while (!nodeArr[beforeTailIndex].next.equals(tail)) {
      beforeTailIndex = nodeArr[beforeTailIndex].next;
    }

    nodeArr[beforeTailIndex].next = null;
    nodeArr[tail] = new Node<>();
    deletedIndexQueue.offer(tail);
    tail = beforeTailIndex;

    size--;
  }

  public void remove(E e) {
    if (head == null) throw new RuntimeException("head is null!");

    Integer removeIndex = head;
    Integer prevIndex = null;
    while (removeIndex != null) {
      if (nodeArr[removeIndex].data.compareTo(e) == 0) break;

      prevIndex = removeIndex;
      removeIndex = nodeArr[removeIndex].next;
    }

    if (Objects.isNull(removeIndex)) System.out.println("대상이 없습니다");
    else if (removeIndex.equals(head)) removeFirst();
    else {
      if (removeIndex.equals(tail)) tail = prevIndex;

      nodeArr[prevIndex].next = nodeArr[removeIndex].next;
      nodeArr[removeIndex] = new Node<>();
      deletedIndexQueue.offer(removeIndex);
      size--;
    }
  }

  public E search(E e) {
    Integer findIndex = head;
    while (findIndex != null) {
      if (nodeArr[findIndex].data.compareTo(e) == 0) return nodeArr[findIndex].data;

      findIndex = nodeArr[findIndex].next;
    }

    return null;
  }

  public void clear() {
    for (int i = 0; i < nodeArr.length; i++) {
      nodeArr[i] = new Node<>();
    }

    deletedIndexQueue = new ArrayDeque<>();
    head = tail = null;
    size = 0;
  }

  public int size() {
    return size;
  }

  public void purge() {
    Integer nodeIndex = head;

    while (nodeArr[nodeIndex].next != null) {
      Integer selectIndex = nodeArr[nodeIndex].next;
      int prevIndex = nodeIndex;

      while (selectIndex != null) {
        if (nodeArr[selectIndex].data.compareTo(nodeArr[nodeIndex].data) == 0) {
          nodeArr[prevIndex].next = nodeArr[selectIndex].next;
          nodeArr[selectIndex] = new Node<>();

          deletedIndexQueue.offer(selectIndex);
          size--;
          selectIndex = nodeArr[prevIndex].next;
        } else {
          prevIndex = selectIndex;
          selectIndex = nodeArr[selectIndex].next;
        }
      }

      nodeIndex = nodeArr[nodeIndex].next;
    }
  }

  public E retrieve(int count) {
    if (count > size) return null;

    int counter = 1;
    Integer nodeIndex = head;

    while (counter < count) {
      nodeIndex = nodeArr[nodeIndex].next;
      counter++;
    }

    return nodeArr[nodeIndex].data;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");

    if (head != null) {
      Integer nodeIndex = head;

      while (nodeIndex != null) {
        stringBuilder.append(nodeArr[nodeIndex].data + ", ");
        nodeIndex = nodeArr[nodeIndex].next;
      }

      stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");
    }

    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}
