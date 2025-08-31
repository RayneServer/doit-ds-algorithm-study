package dev.coma.data.stackqueue.quiz;

public class Quiz07 {
  private int[] queArr;
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

  public Quiz07(int capacity) {
    dataNum = frontPointer = rearPointer = 0;
    this.capacity = capacity;

    try {
      queArr = new int[this.capacity];
    } catch (OutOfMemoryError e) {
      this.capacity = 0;
    }
  }

  public int frontEnque(int x) throws OverflowIntQueueException {
    if (dataNum >= capacity) throw new OverflowIntQueueException();

    frontPointer--;
    if (frontPointer < 0) frontPointer = capacity - 1;
    queArr[frontPointer] = x;
    dataNum++;

    return x;
  }

  public int rearEnque(int x) throws OverflowIntQueueException {
    if (dataNum >= capacity) throw new OverflowIntQueueException();

    queArr[rearPointer++] = x;
    dataNum++;
    if (rearPointer == capacity) rearPointer = 0;
    return x;
  }

  public int frontDeque() throws EmptyIntQueueException {
    if (dataNum <= 0) throw new EmptyIntQueueException();

    int result = queArr[frontPointer++];
    dataNum--;

    if (frontPointer == capacity) frontPointer = 0;
    return result;
  }

  public int rearDeque() throws EmptyIntQueueException {
    if (dataNum <= 0) throw new EmptyIntQueueException();

    rearPointer--;
    if (rearPointer < 0) rearPointer = capacity - 1;

    int result = queArr[rearPointer];
    dataNum--;

    return result;
  }

  public int frontPeek() throws EmptyIntQueueException {
    if (dataNum <= 0) throw new EmptyIntQueueException();

    return queArr[frontPointer];
  }

  public int rearPeek() throws EmptyIntQueueException {
    if (dataNum <= 0) throw new EmptyIntQueueException();

    return rearPointer == 0 ? queArr[capacity - 1] : queArr[rearPointer - 1];
  }

  public void clear() {
    dataNum = frontPointer = rearPointer = 0;
  }

  public int indexOf(int x) {
    for (int i = 0; i < dataNum; i++) {
      int idx = (frontPointer + i) % capacity;
      if (queArr[idx] == x) return idx;
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
