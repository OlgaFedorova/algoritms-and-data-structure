package algoritms.sorting;

import java.util.Arrays;

/**
 * Позырьковая сортировка
 * Сложность: O(N^2)
 * (N–1) + (N–2) + (N–3) + ... + 1 = N × (N–1)/2
 * а это около N^2/2
 * Внешний цикл выполняется N раз, внутренний цикл — тоже N раз для каждой итерации внешнего цикла
 * (или N, разделенное на константу). Таким образом, всего будет выполнено N×N, или N^2 итераций.
 */
public class BubbleSort {

    public static void sort(long[] arr) {
        int out, in;
        for (out = arr.length - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (arr[in] > arr[in + 1]) {
                    swap(in, in + 1, arr);
                }
            }
        }
    }

    private static void swap(int one, int two, long[] arr) {
        long temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    public static void main(String[] args) {
        long[] arr = {1, 7, 5, 9, 2, 6, 34, 65, 2, 6, 11, 76, 2, 34, 123, 7, 4};
        System.out.println("Before algoritms.sorting: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("After algoritms.sorting: " + Arrays.toString(arr));
    }
}
