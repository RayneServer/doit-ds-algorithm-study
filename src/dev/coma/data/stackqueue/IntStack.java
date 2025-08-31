package dev.coma.data.stackqueue;
public class IntStack {
  private int[] stackArr;
  private int capacity;
  private int pointer;

  // IntStack 에서 쓸 예외들
  @SuppressWarnings("serial")
	public static class EmptyIntStackException extends RuntimeException {
    public EmptyIntStackException() {}
  }

  @SuppressWarnings("serial")
	public static class OverflowIntStackException extends RuntimeException {
    public OverflowIntStackException() {}
  }

  public IntStack(int maxlength) {
    this.pointer = 0;
    this.capacity = maxlength;

    try {
      stackArr = new int[this.capacity];
    } catch (OutOfMemoryError e) {
      capacity = 0;
    }
  }

  public int push(int x) throws OverflowIntStackException {
    if (pointer >= capacity) throw new OverflowIntStackException();

    return stackArr[pointer++] = x;
  }

  public int pop() throws EmptyIntStackException {
    if (pointer <= 0) throw new EmptyIntStackException();

    return stackArr[--pointer];
  }

  public int peek() throws EmptyIntStackException {
    if (pointer <= 0) throw new EmptyIntStackException();

    return stackArr[pointer - 1];
  }

  public void clear() {
    pointer = 0;
  }

  public int indexOf(int x) {
    for (int i = pointer - 1; i >= 0; i--) {
      if (stackArr[i] == x) return i;
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
