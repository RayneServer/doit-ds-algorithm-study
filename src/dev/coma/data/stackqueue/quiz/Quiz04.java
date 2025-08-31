package dev.coma.data.stackqueue.quiz;

public class Quiz04 {
  private int[] que;
  private int capacity;
  private int pointer;

  @SuppressWarnings("serial")
	public static class EmptyIntQueueException extends RuntimeException {
    public EmptyIntQueueException() {}
  }

  @SuppressWarnings("serial")
	public static class OverflowIntQueueException extends RuntimeException {
    public OverflowIntQueueException() {}
  }

  public Quiz04(int capacity) {
    this.capacity = capacity;
    pointer = 0;

    try {
      que = new int[this.capacity];
    } catch (OutOfMemoryError e) {
      this.capacity = 0;
    }
  }

  public int enque(int x) throws OverflowIntQueueException {
    if (pointer >= capacity) throw new OverflowIntQueueException();

    que[pointer++] = x;
    return x;
  }

  public int deque() throws EmptyIntQueueException {
    if (pointer <= 0) throw new EmptyIntQueueException();

    int result = que[0];
    for (int i = 1; i < pointer; i++) {
      que[i - 1] = que[i];
    }

    pointer--;
    return result;
  }

  public int peek() throws EmptyIntQueueException {
    if (pointer <= 0) throw new EmptyIntQueueException();

    return que[0];
  }

  public void clear() {
    pointer = 0;
  }

  public int indexOf(int x) {
    for (int i = 0; i < pointer; i++) {
      if (que[i] == x) return i;
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
    if (pointer <= 0) System.out.println("큐가 비어 있습니다.");
    else {
      for (int i = 0; i < pointer; i++) {
        System.out.print(que[i] + " ");
      }

      System.out.println();
    }
  }
}
