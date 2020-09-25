package ofedorova.data_structures.priority_queue;

public class PriorityQueueApp {

  public static void main(String[] args) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(4);
    priorityQueue.insert(30);
    priorityQueue.insert(50);
    priorityQueue.insert(10);
    priorityQueue.insert(40);
    priorityQueue.insert(20);

    System.out.println(priorityQueue);
    System.out.println("Min: " + priorityQueue.peekMin());

    priorityQueue.insert(5);

    System.out.println(priorityQueue);
    System.out.println("Min: " + priorityQueue.peekMin());
    System.out.println("Remove: " + priorityQueue.remove());
    System.out.println(priorityQueue);
    System.out.println("Min: " + priorityQueue.peekMin());
  }
}
