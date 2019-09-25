package data_structures.priority_queue;

import java.util.Arrays;

public class PriorityQueue<T extends Comparable> {

  private int maxSize;
  private Comparable[] queueArray;
  private int size;

  public PriorityQueue(int maxSize) {
    this.maxSize = maxSize;
    this.queueArray = new Comparable[maxSize];
  }

  public void insert(T item) {
    resize();
    if (size == 0) {
      queueArray[size++] = item;
    } else {
      int j = size - 1;
      while (j >= 0) {
        if (item.compareTo(queueArray[j]) > 0) {
          queueArray[j + 1] = queueArray[j];
        } else {
          break;
        }
        j--;
      }
      queueArray[j + 1] = item;
      size++;
    }
  }


  public T remove() {
    return (T) queueArray[--size];
  }

  public T peekMin() {
    return (T) queueArray[size - 1];
  }

  private void resize() {
    if (size == maxSize) {
      int newMaxSize = maxSize * 2;
      Comparable[] temp = new Comparable[newMaxSize];
      System.arraycopy(queueArray, 0, temp, 0, size);
      queueArray = temp;
      maxSize = newMaxSize;
    }
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    for (int j = size -1; j >= 0; j--){
      result.append(queueArray[j]).append(" ");
    }
    return result.toString();
  }
}
