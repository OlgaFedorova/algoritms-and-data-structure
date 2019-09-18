package data_structure.queue;

public class QueueApp {

  public static void main(String[] args) {
    useCase1();
    useCase2();
    useCase3();
    useCase4();
  }

  private static void useCase1() {
    System.out.println("use case front = 0, rear = 2");
    Queue<Integer> queue = new Queue<>(4);
    queue.insert(3);
    queue.insert(5);
    System.out.println(queue);
  }

  private static void useCase2() {
    System.out.println("use case front = 0, rear = 5");
    Queue<Integer> queue = new Queue<>(4);
    queue.insert(3);
    queue.insert(5);
    queue.insert(1);
    queue.insert(6);
    queue.insert(1);
    System.out.println(queue);
  }

  private static void useCase3() {
    System.out.println("use case front = 2, rear = 1");
    Queue<Integer> queue = new Queue<>(4);
    queue.insert(3);
    queue.insert(5);
    queue.insert(1);
    queue.insert(6);
    System.out.println(queue);
    queue.remove();
    queue.remove();
    System.out.println(queue);
    queue.insert(11);
    queue.insert(12);
    System.out.println(queue);
  }

  private static void useCase4() {
    System.out.println("use case front = 0, rear = 5");
    Queue<Integer> queue = new Queue<>(4);
    queue.insert(3);
    queue.insert(5);
    queue.insert(1);
    queue.insert(6);
    System.out.println(queue);
    queue.remove();
    queue.remove();
    System.out.println(queue);
    queue.insert(11);
    queue.insert(12);
    queue.insert(13);
    System.out.println(queue);
  }
}
