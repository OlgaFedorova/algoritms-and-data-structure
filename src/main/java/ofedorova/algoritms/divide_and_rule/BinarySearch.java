package ofedorova.algoritms.divide_and_rule;

/**
 * Ддвоичный поиск
 *
 * В первой строке даны целое число 1≤n≤10^5 и массив A[1…n] из n различных натуральных чисел,
 * не превышающих 10^9, в порядке возрастания, во второй — целое число 1≤k≤10^5 и k натуральных
 * чисел b1,...,b_k, не превышающих 10^9. Для каждого i от 1 до k необходимо вывести индекс 1≤j≤n,
 * для которого A[j]=b_i, или -1, если такого j нет.
 *
 *
 * Sample Input:
 *
 * 5 1 5 8 12 13
 * 5 8 1 23 1 11
 *
 * Sample Output:
 *
 * 3 1 -1 1 -1
 */
public class BinarySearch {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
             b[i] = scanner.nextInt();
        }

        for (int i = 0; i < k; i++) {
            System.out.print(binarySearch(arr, b[i]) + " ");
        }
    }

    public static int binarySearch(int[] arr, int key) {
        int l = 0;
        int r = arr.length - 1;
        int m;

        while (l <= r) {
            m = (l + r)/2;
            if (arr[m] == key){
                return m + 1;
            }

            if (key < arr[m]){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }
}
