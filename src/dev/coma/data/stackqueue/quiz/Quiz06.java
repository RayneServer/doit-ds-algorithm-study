package dev.coma.data.stackqueue.quiz;

public class Quiz06<E> {
  private E[] queArr;
  private int capacity;
  private int frontPointer;
  private int rearPointer;
  private int dataNum;

  @SuppressWarnings("serial")
	public static class EmptyIntQueueException extends RuntimeException {
    public EmptyIntQueueException() {}
  }

  @SuppressWarnings("serial")
	public static class OverflowIntQueueException extends RuntimeException {
    public OverflowIntQueueException() {}
  }

  @SuppressWarnings("unchecked")
	public Quiz06(int capacity) {
    dataNum = frontPointer = rearPointer = 0;
    this.capacity = capacity;

    try {
      queArr = (E[]) new Object[this.capacity];
    } catch (OutOfMemoryError e) {
      this.capacity = 0;
    }
  }

  public E enque(E e) throws OverflowIntQueueException {
    if (dataNum >= capacity) throw new OverflowIntQueueException();

    queArr[rearPointer++] = e;
    dataNum++;
    if (rearPointer == capacity) rearPointer = 0;
    return e;
  }

  public E deque() throws EmptyIntQueueException {
    if (dataNum <= 0) throw new EmptyIntQueueException();

    E result = queArr[frontPointer++];
    dataNum--;

    if (frontPointer == capacity) frontPointer = 0;
    return result;
  }

  public E peek() throws EmptyIntQueueException {
    if (dataNum <= 0) throw new EmptyIntQueueException();

    return queArr[frontPointer];
  }

  public void clear() {
    dataNum = frontPointer = rearPointer = 0;
  }

  public int indexOf(E e) {
    for (int i = 0; i < dataNum; i++) {
      int idx = (frontPointer + i) % capacity;
      if (queArr[idx] == e) return idx;
    }

    return -1;
  }

  public int getCapacity() {
    return capacity;
  }

  public int size() {
    return dataNum;
  }

  public boolean isEmpty() {
    return dataNum <= 0;
  }

  public boolean isFull() {
    return dataNum >= capacity;
  }

  public void dump() {
    if (dataNum <= 0) System.out.println("큐가 비어 있습니다.");
    else {
      for (int i = 0; i < dataNum; i++) {
        System.out.println(queArr[(frontPointer + i) % capacity]);
      }

      System.out.println();
    }
  }
}
