package ofedorova.algoritms.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Сортировка слиянием. Итеративная реализация.
 * Сложность:  O(N × logN )
 * Недостаток алгоритма заключается в том, что требуется выделение в памяти дополнительного массива
 * с размером, равным размеру сортируемого массива.
 */
public class IterativeMergeSort {

    public static long[] sort(long[] arr) {
        Queue<long[]> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i ++) {
            queue.add(new long[]{arr[i]});
        }

        while (queue.size() > 1) {
            queue.add(merge(queue.poll(), queue.poll()));
        }

        return queue.poll();
    }

    private static long[] merge(long[] arr1, long[] arr2) {
        int j = 0;
        long[] workSpace = new long[arr1.length + arr2.length];
        int lowFirst = 0;
        int lowSecond = 0;

        while (lowFirst < arr1.length && lowSecond < arr2.length) {
            if (arr1[lowFirst] < arr2[lowSecond]) {
                workSpace[j++] = arr1[lowFirst++];
            } else {
                workSpace[j++] = arr2[lowSecond++];
            }
        }

        while (lowFirst < arr1.length) {
            workSpace[j++] = arr1[lowFirst++];
        }

        while (lowSecond < arr2.length) {
            workSpace[j++] = arr2[lowSecond++];
        }

        return workSpace;
    }

    public static void main(String[] args) {

        long[] arr = {65, 1, 7, 5, 9};
        System.out.println("Before algoritms.sorting: " + Arrays.toString(arr));
        System.out.println("After algoritms.sorting: " + Arrays.toString(sort(arr)));


        long[] arr1 = {65, 1, 7, 5, 9, 2, 6, 34, 65, 2, 6, 11, 76, 2, 34, 123, 7, 4};
        System.out.println("Before algoritms.sorting: " + Arrays.toString(arr1));
        System.out.println("After algoritms.sorting: " + Arrays.toString(sort(arr1)));
    }
}
