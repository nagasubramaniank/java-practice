// Problem ID: 225. Min Coin.
//
// Given the list of coins of distinct denominations and total amount of money. Output the minimum number of coins
// required to make up that amount. Output -1 if that money cannot be made up using given coins. You may assume that
// there are infinite numbers of coins of each type.
//
// Input:
//
// The first line contains 'T' denoting the number of test cases. Then follows description of test cases. Each case
// begins with the two space separated integers 'n' and 'amount' denoting the total number of distinct coins and total
// amount of money respectively. The second line contains N space-separated integers A1, A2, ..., AN denoting the values
// of coins.
//
// Output:
//
// Print the minimum number of coins required to make up that amount or return -1 if it is impossible to make that
// amount using given coins.
//
// Constraints:
//
// 1 <= T <= 30
// 1 <= n <= 100
// 1 <= Ai <= 1000
// 1 <= amount <= 100000
//
// Example:
//
// Input:
// 2
// 3 11
// 1 2 5
// 2 7
// 2 6
//
// Output:
// 3
// -1

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Arrays;
import java.util.Scanner;

public class P0225_MinimumCoins {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int amount = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printMinimumCoins(amount, A);
        }
    }

    private static void printMinimumCoins(final int totalAmount, final int[] coinValues) {

        final int[] minimumCoins = new int[totalAmount + 1];

        Arrays.sort(coinValues);

        for (int amount = 1; amount <= totalAmount; amount++) {
            minimumCoins[amount] = Integer.MAX_VALUE;

            for (int coin = 0; coin < coinValues.length && coinValues[coin] <= amount; coin++) {
                if (minimumCoins[amount - coinValues[coin]] != Integer.MAX_VALUE) {
                    minimumCoins[amount] = Math.min(minimumCoins[amount], minimumCoins[amount - coinValues[coin]] + 1);
                }
            }
        }

        System.out.println(minimumCoins[totalAmount] != Integer.MAX_VALUE ? minimumCoins[totalAmount] : -1);
    }
}
