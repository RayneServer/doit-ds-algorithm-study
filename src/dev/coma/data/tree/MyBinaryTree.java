package dev.coma.data.tree;

import java.util.Objects;

public class MyBinaryTree<K extends Comparable<K>, V> {
  private Node<K, V> rootNode;

  private static class Node<K, V> {
    private K key;
    private V value;
    private Node<K, V> leftChild;
    private Node<K, V> rightChild;

    public Node(K key, V value, Node<K, V> leftChild, Node<K, V> rightChild) {
      this.key = key;
      this.value = value;
      this.leftChild = leftChild;
      this.rightChild = rightChild;
    }

    public K getKey() {
      return key;
    }

    public V getValue() {
      return value;
    }

    public void print() {
      System.out.println(value);
    }
  }

  public MyBinaryTree() {
    rootNode = null;
  }

  public void add(K key, V value) {
    if (rootNode == null) rootNode = new Node<>(key, value, null, null);
    else addNode(rootNode, key, value);
  }

  public boolean remove(K key) {
    Node<K, V> pointNode = rootNode;
    Node<K, V> parentNode = null;
    boolean isLeftChild = true;

    while (true) {
      if (pointNode == null) return false;

      int compareResult = compareKey(key, pointNode.getKey());
      if (compareResult == 0) break;
      else {
        parentNode = pointNode;

        if (compareResult < 0) {
          isLeftChild = true;
          pointNode = pointNode.leftChild;
        } else {
          isLeftChild = false;
          pointNode = pointNode.rightChild;
        }
      }
    }

    if (pointNode.leftChild == null) {
      if (pointNode == rootNode) rootNode = pointNode.rightChild;
      else if (isLeftChild) parentNode.leftChild = pointNode.rightChild;
      else parentNode.rightChild = pointNode.rightChild;
    } else if (pointNode.rightChild == null) {
      if (pointNode == rootNode) rootNode = pointNode.leftChild;
      else if (isLeftChild) parentNode.leftChild = pointNode.leftChild;
      else parentNode.rightChild = pointNode.leftChild;
    } else {
      parentNode = pointNode;
      Node<K, V> maxLeftNode = pointNode.leftChild;
      isLeftChild = true;

      while (maxLeftNode.rightChild != null) {
        parentNode = maxLeftNode;
        maxLeftNode = maxLeftNode.rightChild;
        isLeftChild = false;
      }

      pointNode.key = maxLeftNode.key;
      pointNode.value = maxLeftNode.value;

      if (isLeftChild) parentNode.leftChild = maxLeftNode.leftChild;
      else parentNode.rightChild = maxLeftNode.leftChild;
    }

    return true;
  }

  public V search(K key) {
    Node<K, V> pointNode = rootNode;

    while (true) {
      if (pointNode == null) return null;

      int compareResult = compareKey(key, pointNode.getKey());
      if (compareResult == 0) return pointNode.getValue();
      else if (compareResult < 0) pointNode = pointNode.leftChild;
      else pointNode = pointNode.rightChild;
    }
  }

  public K getMinKey() {
    return getMinNode().getKey();
  }

  public V getValueWithMinKey() {
    return getMinNode().getValue();
  }

  public K getMaxKey() {
    return getMaxNode().getKey();
  }

  public V getValueWithMaxKey() {
    return getMaxNode().getValue();
  }

  public void print() {
    printNode(rootNode);
  }

  public void printReverse() {
    printNodeReverse(rootNode);
  }

  private void addNode(Node<K, V> node, K key, V value) {
    int compareResult = compareKey(key, node.getKey());

    if (compareResult == 0) {
      System.out.println("동일한 값이 존재합니다.");
    } else if (compareResult < 0) {
      if (node.leftChild == null) node.leftChild = new Node<>(key, value, null, null);
      else addNode(node.leftChild, key, value);
    } else {
      if (node.rightChild == null) node.rightChild = new Node<>(key, value, null, null);
      else addNode(node.rightChild, key, value);
    }
  }

  private int compareKey(K key1, K key2) {
    return key1.compareTo(key2);
  }

  private Node<K, V> getMinNode() {
    Node<K, V> pointNode = rootNode;

    while (pointNode.leftChild != null) pointNode = pointNode.leftChild;

    if (pointNode.rightChild != null) pointNode = pointNode.rightChild;
    return pointNode;
  }

  private Node<K, V> getMaxNode() {
    Node<K, V> pointNode = rootNode;

    while (pointNode.rightChild != null) pointNode = pointNode.rightChild;

    if (pointNode.leftChild != null) pointNode = pointNode.leftChild;
    return pointNode;
  }

  private void printNode(Node<K, V> node) {
    if (Objects.isNull(node)) return;

    printNode(node.leftChild);
    System.out.println(node.getKey() + " " + node.getValue());
    printNode(node.rightChild);
  }

  private void printNodeReverse(Node<K, V> node) {
    if (Objects.isNull(node)) return;

    printNode(node.rightChild);
    System.out.println(node.getKey() + " " + node.getValue());
    printNode(node.leftChild);
  }
}
