package sorting;

import java.util.Arrays;

/**
 * Сортировка методом вставки
 * Сложность:  O(N^2)
 */
public class InsertSort {

    public static void sort(long[] arr) {
        int in, out;
        for (out = 1; out < arr.length; out++) {
            long temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = temp;
        }
    }

    public static void main(String[] args) {
        long[] arr = {1, 7, 5, 9, 2, 6, 34, 65, 2, 6, 11, 76, 2, 34, 123, 7, 4};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
