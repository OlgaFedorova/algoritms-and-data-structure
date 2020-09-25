package ofedorova.algoritms.sorting;

import java.util.Arrays;

/**
 * Сортировка методом выбора
 * Сложность:  количество перестановок O(N ), количество сравнений  O(N^2)
 */
public class SelectionSort {

    public static void sort(long[] arr) {
        int out, in, min;
        for (out = 0; out < arr.length - 1; out++) {
            min = out;
            for (in = out + 1; in < arr.length; in++) {
                if (arr[in] < arr[min]) {
                    min = in;
                }
            }
            swap(out, min, arr);
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
