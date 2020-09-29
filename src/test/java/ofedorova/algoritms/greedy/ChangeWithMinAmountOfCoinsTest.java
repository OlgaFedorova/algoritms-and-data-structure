package ofedorova.algoritms.greedy;


import ofedorova.algoritms.greedy.ChangeWithMinAmountOfCoins.Coin;
import org.junit.Assert;
import org.junit.Test;

import static ofedorova.algoritms.greedy.ChangeWithMinAmountOfCoins.changeWithMinAmountOfCoins;

public class ChangeWithMinAmountOfCoinsTest {

    @Test
    public void changeWithMinAmountOfCoinsTest() {
        Assert.assertArrayEquals(new Coin[]{
                        new Coin(25, 2),
                        new Coin(10, 1),
                        new Coin(5, 1),
                        new Coin(1, 2)},
                changeWithMinAmountOfCoins(67));

        Assert.assertArrayEquals(new Coin[]{
                        new Coin(25, 1),
                        new Coin(10, 0),
                        new Coin(5, 0),
                        new Coin(1, 0)},
                changeWithMinAmountOfCoins(25));

        Assert.assertArrayEquals(new Coin[]{
                        new Coin(25, 0),
                        new Coin(10, 2),
                        new Coin(5, 0),
                        new Coin(1, 0)},
                changeWithMinAmountOfCoins(20));

        Assert.assertArrayEquals(new Coin[]{
                        new Coin(25, 0),
                        new Coin(10, 1),
                        new Coin(5, 1),
                        new Coin(1, 4)},
                changeWithMinAmountOfCoins(19));

        Assert.assertArrayEquals(new Coin[]{
                        new Coin(25, 0),
                        new Coin(10, 1),
                        new Coin(5, 0),
                        new Coin(1, 0)},
                changeWithMinAmountOfCoins(10));

        Assert.assertArrayEquals(new Coin[]{
                        new Coin(25, 0),
                        new Coin(10, 0),
                        new Coin(5, 1),
                        new Coin(1, 4)},
                changeWithMinAmountOfCoins(9));

        Assert.assertArrayEquals(new Coin[]{
                        new Coin(25, 0),
                        new Coin(10, 0),
                        new Coin(5, 1),
                        new Coin(1, 0)},
                changeWithMinAmountOfCoins(5));

        Assert.assertArrayEquals(new Coin[]{
                        new Coin(25, 0),
                        new Coin(10, 0),
                        new Coin(5, 0),
                        new Coin(1, 4)},
                changeWithMinAmountOfCoins(4));

        Assert.assertArrayEquals(new Coin[]{
                        new Coin(25, 0),
                        new Coin(10, 0),
                        new Coin(5, 0),
                        new Coin(1, 1)},
                changeWithMinAmountOfCoins(1));
    }
}