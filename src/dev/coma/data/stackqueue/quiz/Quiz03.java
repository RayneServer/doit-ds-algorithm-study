package dev.coma.data.stackqueue.quiz;

import dev.coma.data.stackqueue.IntStack;

public class Quiz03 {
  private int[] stackArr;
  private int capacity;
  private int leftPointer;
  private int rightPointer;

  @SuppressWarnings("serial")
	public static class EmptyIntStackException extends RuntimeException {
    public EmptyIntStackException() {}
  }

  @SuppressWarnings("serial")
	public static class OverflowIntStackException extends RuntimeException {
    public OverflowIntStackException() {}
  }

  public Quiz03(int maxlength) {
    leftPointer = 0;
    rightPointer = maxlength - 1;
    capacity = maxlength;

    try {
      stackArr = new int[this.capacity];
    } catch (OutOfMemoryError e) {
      capacity = 0;
      rightPointer = 0;
    }
  }

  public int pushLeft(int x) throws IntStack.OverflowIntStackException {
    if (leftPointer >= rightPointer || leftPointer >= capacity) throw new IntStack.OverflowIntStackException();

    return stackArr[leftPointer++] = x;
  }

  public int pushRight(int x) throws IntStack.OverflowIntStackException {
    if (leftPointer >= rightPointer || rightPointer <= 0) throw new IntStack.OverflowIntStackException();

    return stackArr[rightPointer--] = x;
  }

  public int popLeft() throws IntStack.EmptyIntStackException {
    if (leftPointer <= 0) throw new IntStack.EmptyIntStackException();

    return stackArr[--leftPointer];
  }

  public int popRight() throws IntStack.EmptyIntStackException {
    if (rightPointer >= stackArr.length - 1) throw new IntStack.EmptyIntStackException();

    return stackArr[++rightPointer];
  }

  public int peekLeft() throws IntStack.EmptyIntStackException {
    if (leftPointer <= 0) throw new IntStack.EmptyIntStackException();

    return stackArr[leftPointer - 1];
  }

  public int peekRight() throws IntStack.EmptyIntStackException {
    if (rightPointer >= stackArr.length - 1) throw new IntStack.EmptyIntStackException();

    return stackArr[rightPointer + 1];
  }

  public void clearLeft() {
    leftPointer = 0;
  }

  public void clearRight() {
    rightPointer = stackArr.length - 1;
  }

  public int leftIndexOf(int x) {
    for (int i = 0; i < leftPointer; i++) {
      if (stackArr[i] == x) return i;
    }

    return -1;
  }

  public int rightIndexOf(int x) {
    for (int i = rightPointer + 1; i < stackArr.length; i++) {
      if (stackArr[i] == x) return (stackArr.length - 1 - i);
    }

    return -1;
  }

  public int getCapacity() {
    return capacity;
  }

  public int leftSize() {
    return leftPointer;
  }

  public int rightSize() {
    return stackArr.length - rightPointer - 1;
  }

  public boolean isLeftEmpty() {
    return leftPointer <= 0;
  }

  public boolean isRightEmpty() {
    return rightPointer >= stackArr.length - 1;
  }

  public boolean isFull() {
    return leftPointer >= rightPointer;
  }

  public void leftDump() {
    if (leftPointer <= 0) System.out.println("스택이 비어 있습니다.");
    else {
      for (int i = 0; i < leftPointer; i++) {
        System.out.print(stackArr[i] + " ");
      }

      System.out.println();
    }
  }

  public void rightDump() {
    if (rightPointer >= stackArr.length - 1) System.out.println("스택이 비어 있습니다.");
    else {
      for (int i = stackArr.length - 1; i > rightPointer; i--) {
        System.out.println(stackArr[i] + " ");
      }

      System.out.println();
    }
  }
}
