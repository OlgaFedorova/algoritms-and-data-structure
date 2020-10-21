package ofedorova.algoritms.divide_and_rule;

/**
 * Число инверсий
 *
 * Первая строка содержит число 1≤n≤10^5, вторая — массив A[1…n],
 * содержащий натуральные числа, не превосходящие 10^9.
 * Необходимо посчитать число пар индексов 1≤i<j≤n, для которых A[i]>A[j].
 * (Такая пара элементов называется инверсией массива. Количество инверсий в массиве является
 * в некотором смысле его мерой неупорядоченности: например, в упорядоченном по неубыванию массиве
 * инверсий нет вообще, а в массиве, упорядоченном по убыванию, инверсию образуют каждые два элемента.)
 *
 * Sample Input:
 *
 * 5
 * 2 3 9 2 9
 * Sample Output:
 *
 * 2
 */
public class NumberOfInversions {

    public static class Inversions {
        private final int[] arr;
        private final int[] temp;
        private long countOfInversions = 0;

        public Inversions(int[] arr) {
            this.arr = arr;
            this.temp = new int[arr.length];
        }

        public void sortAndCountInversions() {
            sort(0, arr.length - 1);
        }

        private void sort(int start, int end) {
            if (start == end) {
                return;
            }
            int mid = (start + end)/2;
            sort(start, mid);
            sort(mid + 1, end);
            merge(start, end, mid);
        }

        private void merge(int start, int end, int mid){
            int i = start;
            int j = mid + 1;
            int k = 0;

            while (i <= mid && j <= end){
                if (arr[i] <= arr[j]){
                    temp[k++] = arr[i++];
                } else {
                    // a[i], a[i+1]...a[mid]
                    countOfInversions = countOfInversions + mid - i + 1;
                    temp[k++] = arr[j++];
                }
            }

            while (i <= mid){
                temp[k++] = arr[i++];
            }

            while (j <= end){
                temp[k++] = arr[j++];
            }

            System.arraycopy(temp, 0, arr, start, k);
        }
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Inversions inversions = new Inversions(arr);
        inversions.sortAndCountInversions();
        System.out.println(inversions.countOfInversions);

    }
}
