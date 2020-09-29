package ofedorova.algoritms.greedy;

/**
 * Непрерывный рюкзак
 * Первая строка содержит количество предметов 1≤n≤10^3 и вместимость рюкзака 0≤W≤2⋅10^6.
 * Каждая из следующих n строк задаёт стоимость 0≤c≤2⋅10^6 и объём 0<w≤2⋅10^6 предмета (n, W, c, w — целые числа).
 * Выведите максимальную стоимость частей предметов (от каждого предмета можно отделить любую часть, стоимость и объём
 * при этом пропорционально уменьшатся), помещающихся в данный рюкзак, с точностью не менее трёх знаков после запятой.
 *
 * _______________________
 * Sample Input:
 *
 * 3 50
 * 60 20
 * 100 50
 * 120 30
 * _______________________
 * Sample Output:
 *
 * 180.000
 */
public class СontinuousBackpack {

    public static class Item {
        private final int cost;
        private final int weight;

        public Item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }

    }

    public static void main(String[] args) {

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        short n = scanner.nextShort();
        int W = scanner.nextInt();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++){
            items[i] = new Item(scanner.nextInt(), scanner.nextInt());
        }

        java.util.Arrays.sort(items, (i1, i2) -> {
            double perUnit1 = (double) i1.cost / i1.weight;
            double perUnit2 = (double) i2.cost / i2.weight;
            return Double.compare(perUnit2, perUnit1);
        });

        double maxCost = 0;
        int freeW = W;
        short i = 0;

        while (freeW > 0 &&  i < n){
            if (items[i].weight <= freeW) {
                maxCost = maxCost + items[i].cost;
                freeW = freeW - items[i].weight;
            } else {
                double costPerUnit = (double) items[i].cost/items[i].weight;
                maxCost = maxCost + costPerUnit * freeW;
                freeW = 0;
            }
            i++;
        }
        System.out.printf("%.3f", maxCost);
    }
}
