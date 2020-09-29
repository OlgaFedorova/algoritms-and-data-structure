package ofedorova.algoritms.greedy;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * Cдача минимальным количеством монет
 *
 * Постройте жадный алгоритм, который получает на вход натуральное число n и за время O(n) находит минимальное число
 * монет номиналом 1 копейка, 5 копеек, 10 копеек и 25 копеек, с помощью которых можно выдать сдачу в n копеек.
 *
 */
public class ChangeWithMinAmountOfCoins {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int summa = scanner.nextInt();
        if (summa < 0) {
            throw new IllegalArgumentException("Summa is not correct");
        }

        System.out.println(Arrays.toString(changeWithMinAmountOfCoins(summa)));
    }

    public static Coin[] changeWithMinAmountOfCoins(int summa){
        int changeBy25 = summa/ 25;
        int changeBy10 = (summa - changeBy25 * 25) / 10;
        int changeBy5 = (summa - changeBy25 * 25 - changeBy10 * 10) / 5;
        int changeBy1 = summa - changeBy25 * 25 - changeBy10 * 10 - changeBy5 * 5;

        return new Coin[]{new Coin(25, changeBy25),
                new Coin(10, changeBy10), new Coin(5, changeBy5),
                new Coin(1, changeBy1)};
    }

    static class Coin {
        private final int nominal;
        private final int count;

        public Coin(int nominal, int count) {
            this.nominal = nominal;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coin coin = (Coin) o;
            return nominal == coin.nominal &&
                    count == coin.count;
        }

        @Override
        public int hashCode() {
            return Objects.hash(nominal, count);
        }

        @Override
        public String toString() {
            return "Coin{" +
                    "nominal=" + nominal +
                    ", count=" + count +
                    '}';
        }

    }
}
