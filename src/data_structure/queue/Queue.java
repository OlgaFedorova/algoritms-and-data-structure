package data_structure.queue;

public class Queue<T> {

  private int maxSize;
  private Object[] queArray;
  private int front;
  private int rear;
  private int size;

  public Queue(int s) {
    maxSize = s;
    queArray = new Object[maxSize];
    front = 0;
    rear = -1;
    size = 0;
  }

  public void insert(T element) {
    checkBorders();
    queArray[++rear] = element;
    size++;
  }

  public T remove() {
    T temp = (T) queArray[front++];
    if (front == maxSize) {
      front = 0;
    }
    size--;
    return temp;
  }


  public T peekFront() {
    return (T) queArray[front];
  }


  public int size() {
    return size;
  }

  @Override
  public String toString() {
    String res;
    if (front <= rear) {
      res = prepareToStringInRange(front, rear + 1);
    } else {
      res = prepareToStringInRange(front, maxSize);
      res += " ";
      res += prepareToStringInRange(0, rear + 1);
    }
    return res;
  }

  private void checkBorders() {
    if (maxSize == size) {
      if (rear == front - 1) {
        int end = this.maxSize;
        this.maxSize = this.maxSize * 2;
        Object[] temp = new Object[this.maxSize];
        System.arraycopy(this.queArray, front, temp, 0, end - front);
        System.arraycopy(this.queArray, 0, temp, end - front, rear + 1);
        front = 0;
        rear = size - 1;
        this.queArray = temp;
      } else {
        this.maxSize = this.maxSize * 2;
        Object[] temp = new Object[this.maxSize];
        System.arraycopy(this.queArray, 0, temp, 0, size);
        front = 0;
        rear = size - 1;
        this.queArray = temp;
      }
    } else {
      if (rear == maxSize - 1) {
        if (front != 0) {
          rear = -1;
        }
      }
    }
  }

  private String prepareToStringInRange(int start, int end) {
    String res = "";
    for (int i = start; i < end; i++) {
      if (i != start) {
        res += " ";
      }
      res += queArray[i];
    }
    return res;
  }
}
