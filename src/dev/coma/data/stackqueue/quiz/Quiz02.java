package dev.coma.data.stackqueue.quiz;

import dev.coma.data.stackqueue.IntStack;

public class Quiz02<E> {
  private E[] stackArr;
  private int capacity;
  private int pointer;

  @SuppressWarnings("serial")
	public static class EmptyStackException extends RuntimeException {
    public EmptyStackException() {}
  }

  @SuppressWarnings("serial")
	public static class OverflowStackException extends RuntimeException {
    public OverflowStackException() {}
  }

  @SuppressWarnings("unchecked")
  public Quiz02(int maxlength) {
    this.pointer = 0;
    this.capacity = maxlength;

    try {
      stackArr = (E[]) new Object[this.capacity];
    } catch (OutOfMemoryError e) {
      capacity = 0;
    }
  }

  public E push(E e) throws IntStack.OverflowIntStackException {
    if (pointer >= capacity) throw new IntStack.OverflowIntStackException();

    return stackArr[pointer++] = e;
  }

  public E pop() throws IntStack.EmptyIntStackException {
    if (pointer <= 0) throw new IntStack.EmptyIntStackException();

    return stackArr[--pointer];
  }

  public E peek() throws IntStack.EmptyIntStackException {
    if (pointer <= 0) throw new IntStack.EmptyIntStackException();

    return stackArr[pointer - 1];
  }

  public void clear() {
    pointer = 0;
  }

  public int indexOf(E e) {
    for (int i = pointer - 1; i >= 0; i--) {
      if (stackArr[i] == e) return i;
    }

    return -1;
  }

  public int getCapacity() {
    return capacity;
  }

  public int size() {
    return pointer;
  }

  public boolean isEmpty() {
    return pointer <= 0;
  }

  public boolean isFull() {
    return pointer >= capacity;
  }

  public void dump() {
    if (pointer <= 0) System.out.println("스택이 비어 있습니다.");
    else {
      for (int i = 0; i < pointer; i++) {
        System.out.print(stackArr[i] + " ");
      }

      System.out.println();
    }
  }
}
