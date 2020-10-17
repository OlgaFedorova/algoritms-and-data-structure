package ofedorova.algoritms.greedy;

/**
 * Очередь с приоритетами
 * http://neerc.ifmo.ru/wiki/index.php?title=Двоичная_куча
 *
 * Первая строка входа содержит число операций 1≤n≤10^5.
 * Каждая из последующих n строк задают операцию одного из следующих двух типов:
 * Insert x, где 0≤x≤10^9 — целое число;
 * ExtractMax.
 * Первая операция добавляет число x в очередь с приоритетами,
 * вторая — извлекает максимальное число и выводит его.
 *
 * ------------------------------------------------
 * Sample Input:
 *
 * 6
 * Insert 200
 * Insert 10
 * ExtractMax
 * Insert 5
 * Insert 500
 * ExtractMax
 *
 * Sample Output:
 *
 * 200
 * 500
 */
public class PriorityQueueMain {

    private static class PriorityQueue {

        private int size = 0;
        private final int[] arr;

        public PriorityQueue(int size) {
            this.arr = new int[size];
        }

        public void insert(int v){
            size++;
            arr[size - 1] = v;
            siftUp(size - 1);
        }

        private void siftDown(int i){
            while (2 * i + 1 < size) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int j = left;
                if (right < size && arr[right] > arr[left]) {
                    j = right;
                }
                if (arr[i] >= arr[j]) {
                    break;
                }
                swap(i, j);
                i = j;
            }
        }

        private void siftUp(int i) {
            while (i > 0 && arr[i] > arr[(i - 1) / 2]) {
                swap(i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }

        private void swap(int i, int j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        public int extractMax(){
            int max = arr[0];
            arr[0] = arr[size - 1];
            size--;
            siftDown(0);
            return max;
        }

    }

    public static void main(String[] args) {

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int operationCount = scanner.nextInt();
        PriorityQueue priorityQueue = new PriorityQueue(operationCount);
        for (int i = 0; i < operationCount; i++){
            String operation = scanner.next();
            if (operation.equals("Insert")){
                int v = scanner.nextInt();
                priorityQueue.insert(v);
            } else if (operation.equals("ExtractMax")){
                System.out.println(priorityQueue.extractMax());
            }
        }
    }
}
