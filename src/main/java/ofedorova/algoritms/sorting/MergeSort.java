package ofedorova.algoritms.sorting;

import java.util.Arrays;

/**
 * Сортировка слиянием
 * Сложность:  O(N × logN )
 * Недостаток алгоритма заключается в том, что требуется выделение в памяти дополнительного массива
 * с размером, равным размеру сортируемого массива.
 */
public class MergeSort {

    public static void sort(long[] arr) {
        long[] workSpace = new long[arr.length];
        recMergeSort(arr, workSpace, 0, arr.length - 1);
    }

    private static void recMergeSort(long[] arr, long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(arr, workSpace, lowerBound, mid);
            recMergeSort(arr, workSpace, mid + 1, upperBound);
            merge(arr, workSpace, lowerBound, mid, upperBound);
        }
    }

    private static void merge(long[] arr, long[] workSpace, int lowerBound, int mid, int upperBound) {
        int j = 0;
        int n = upperBound - lowerBound + 1;
        int lowFirst = lowerBound;
        int lowSecond = mid + 1;

        while (lowFirst <= mid && lowSecond <= upperBound) {
            if (arr[lowFirst] < arr[lowSecond]) {
                workSpace[j++] = arr[lowFirst++];
            } else {
                workSpace[j++] = arr[lowSecond++];
            }
        }

        while (lowFirst <= mid) {
            workSpace[j++] = arr[lowFirst++];
        }

        while (lowSecond <= upperBound) {
            workSpace[j++] = arr[lowSecond++];
        }

        for (j = 0; j < n; j++) {
            arr[lowerBound + j] = workSpace[j];
        }
    }

    public static void main(String[] args) {
        long[] arr = {65, 1, 7, 5, 9, 2, 6, 34, 65, 2, 6, 11, 76, 2, 34, 123, 7, 4};
        System.out.println("Before algoritms.sorting: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("After algoritms.sorting: " + Arrays.toString(arr));
    }
}
