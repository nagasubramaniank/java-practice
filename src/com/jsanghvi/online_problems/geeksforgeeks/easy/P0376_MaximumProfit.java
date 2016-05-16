// Problem ID: 376. Stock buy and sell.
//
// The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in
// those days.
//
// Input:
// First line contains number of test cases T. Each test case contain the integer value 'N' denoting days followed by an
// array of stock prices in N days.
//
// Output:
// The maximum profit is displayed as shown below. And if there is no profit then print "No Profit".
//
// Constraints:
// 1 <= T <= 100
// 2 <= N <= 100
// 1 <= arr[i] <= 10000
//
// Example:
//
// Input:
// 2
// 7
// 100 180 260 310 40 535 695
// 10
// 23 13 25 29 33 19 34 45 65 67
//
// Output:
// (0 3) (4 6)
// (1 4) (5 9)
//
// Notice:
// Output format is as follows - (buy_day sell_day) (buy_day sell_day)
// For each input, output should be in a single line.

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0376_MaximumProfit {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N + 1];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }
            A[N] = Integer.MIN_VALUE;

            printStockPurchasePlan(A);
        }
    }

    private static void printStockPurchasePlan(final int[] dayPrices) {
        StringBuilder output = new StringBuilder();

        for (int startDay = -1, endDay = 0, previousDayPrice = Integer.MAX_VALUE; endDay < dayPrices.length; endDay++) {
            if (previousDayPrice > dayPrices[endDay]) {
                if (startDay != endDay - 1) {
                    output.append('(').append(startDay).append(' ').append(endDay - 1).append(')').append(' ');
                }
                startDay = endDay;
            }
            previousDayPrice = dayPrices[endDay];
        }

        System.out.println(output.length() != 0 ? output : "No Profit");
    }
}
