package ofedorova.algoritms.greedy;

/**
 * Покрыть отрезки точками
 * По данным n отрезкам необходимо найти множество точек минимального размера,
 * для которого каждый из отрезков содержит хотя бы одну из точек.
 *
 * В первой строке дано число 1≤n≤100 отрезков. Каждая из последующих n строк содержит по два числа 0≤l≤r≤10^9,
 * задающих начало и конец отрезка.
 * Выведите оптимальное число m точек и сами m точек. Если таких множеств точек несколько, выведите любое из них.
 * ------------------
 * Sample Input 1:
 * 3
 * 1 3
 * 2 5
 * 3 6
 * Sample Output 1:
 * 1
 * 3
 * -----------------
 * Sample Input 2:
 * 4
 * 4 7
 * 1 3
 * 2 5
 * 5 6
 * Sample Output 2:
 * 2
 * 3 6
 * ----------------
 */
public class CoverageOfSegmentByDots {

    static class Segment {
        private final int start;
        private final int end;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        byte n = scanner.nextByte();
        if (n > 0) {
            Segment[] segments = new Segment[n];

            for (byte i = 0; i < n; i++) {
                segments[i] = new Segment(scanner.nextInt(), scanner.nextInt());
            }

            java.util.Arrays.sort(segments, java.util.Comparator.comparingInt(s -> s.end));

            int[] dots = new int[n];

            // Сохраняем точку окончания самого левого отрезка
            dots[0] = segments[0].end;
            byte count = 1;

            for (byte i = 1; i < n; i++) {
                if (dots[count-1] >= segments[i].start && dots[count-1] <= segments[i].end){
                    continue;
                } else {
                    dots[count++] = segments[i].end;
                }
            }

            System.out.println(count);
            for (byte i = 0; i < count; i++){
                System.out.print(dots[i] + " ");
            }
        }

    }
}
