package dev.coma.data.hash.chain;

import java.util.Objects;

public class ChainHash<K, V> {
  private Node<K, V>[] hashTable;
  private int size;

  private static class Node<K, V> {
    private K key;
    private V value;
    private Node<K, V> nextNode;

    public Node(K key, V value, Node<K, V> nextNode) {
      this.key = key;
      this.value = value;
      this.nextNode = nextNode;
    }

    public K getKey() {
      return key;
    }

    public V getValue() {
      return value;
    }

    @Override
    public String toString() {
      return key + " (" + value + ")";
    }
  }

  public ChainHash(int capacity) {
    hashTable = new Node[capacity];
    size = capacity;
  }

  public boolean add(K key, V value) {
    int hashValue = hashValue(key);
    Node<K, V> pointNode = hashTable[hashValue];

    while (pointNode != null) {
      if (pointNode.getKey().equals(key)) return false;

      pointNode = pointNode.nextNode;
    }

    Node<K, V> newNode = new Node<>(key, value, hashTable[hashValue]);
    hashTable[hashValue] = newNode;
    return true;
  }

  public boolean remove(K key) {
    int hashValue = hashValue(key);
    Node<K, V> pointNode = hashTable[hashValue];
    Node<K, V> prevNode = null;

    while (pointNode != null) {
      if (pointNode.getKey().equals(key)) {
        if (prevNode == null) hashTable[hashValue] = pointNode.nextNode;
        else prevNode.nextNode = pointNode.nextNode;
        return true;
      }

      prevNode = pointNode;
      pointNode = pointNode.nextNode;
    }

    return false;
  }

  public V search(K key) {
    Node<K, V> pointNode = hashTable[hashValue(key)];

    while (pointNode != null) {
      if (pointNode.getKey().equals(key)) return pointNode.getValue();

      pointNode = pointNode.nextNode;
    }

    return null;
  }

  public void print() {
    for (int i = 0; i < size; i++) {
      System.out.print(i + "번 인덱스: ");
      Node<K, V> node = hashTable[i];

      while (node != null) {
        System.out.print(node + " ");
        node = node.nextNode;
      }

      System.out.println();
    }
  }

  private int hashValue(K key) {
    return Objects.hashCode(key) % size;
  }
}
