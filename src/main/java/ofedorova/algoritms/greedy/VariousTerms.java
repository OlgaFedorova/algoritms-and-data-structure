package ofedorova.algoritms.greedy;

/**
 * Различные слагаемые
 *
 * По данному числу 1≤n≤10^9 найдите максимальное число k, для которого n можно представить как сумму k
 * различных натуральных слагаемых. Выведите в первой строке число k, во второй — k слагаемых.
 *
 * ________________________
 * Sample Input 1:
 *
 * 4
 * Sample Output 1:
 *
 * 2
 * 1 3
 * ________________________
 * Sample Input 2:
 *
 * 6
 * Sample Output 2:
 *
 * 3
 * 1 2 3
 */
public class VariousTerms {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int n = scanner.nextInt();

        if (n >= 1){
            StringBuilder result = new StringBuilder();
            int last = n;
            int count = 0;
            for (int i = 1; i <= last; i++) {
                int step = last - i;
                if (step <= i && step > 0) {
                    continue;
                } else {
                    last = step;
                    count++;
                    result.append(i).append(" ");
                }
            }

            System.out.println(count);
            System.out.println(result.toString());
        }
    }
}
