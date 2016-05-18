// Problem ID: 439. Let's go shopping!
//
// A person visits a Nike showroom and sees 5 items available, T-shirts - Rs 1000, bags- Rs 2000, Jackets - Rs 3000,
// Ball - Rs 4000 , Shoes - Rs 5000. All items of same type are priced the same and there are at least 100 pieces of
// every item available. Also there was an offer buy 2 get 1 free on same item. So, he decided to buy some stuff, but he
// had only one condition that number of items he takes home should be minimum.
//
// Input:
// First line of the input is Number of test cases T. Each test case contain the money you have.
//
// Output:
// Minimum number of item you can purchase in total money you have. Otherwise print "No"
//
// Constraints:
// 1 <= T <= 20
// 1 <= N <= 100000
//
// Example:
//
// Input:
// 7
// 100000
// 3500
// 44000
// 2000
// 94000
// 11000
// 22000
//
//
// Output:
// 30
// No
// 13
// 1
// 28
// 3
// 6
//
// Explanation: For Rs 22000 he will buy 1 ball for 4000, 1 jacket for 3000 & 3 shoes for 15000
//
// and he will get 1 extra pair of shoes free. On total making it 6 items.

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0439_MinimizeItems {
    public static void main(final String[] args) {
        final int[] minimumItems = getMinimumItems(100000);

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printMinimumItems(in.nextInt(), minimumItems);
        }
    }

    private static void printMinimumItems(int money, int[] minimumItems) {
        System.out.println((money % 1000 != 0) ? "No" : minimumItems[money / 1000]);
    }

    private static int[] getMinimumItems(int maximumMoney) {
        // It should be okay to compute minimum items at particular money based on minimum items at some lesser money,
        // without considering all combinations of items-counts at previous lesser money.

        maximumMoney /= 1000;
        final int[] prices = new int[]{5, 4, 3, 2, 1};
        final int[] minimumItems = new int[maximumMoney + 1];
        final boolean[][] nextItemFree = new boolean[minimumItems.length][prices.length];

        for (int money = 1; money <= maximumMoney; money++) {
            minimumItems[money] = Integer.MAX_VALUE;

            for (int i = 0; i < prices.length; i++) {
                if (prices[i] <= money) {
                    final int items = minimumItems[money - prices[i]] + (nextItemFree[money - prices[i]][i] ? 2 : 1);

                    if (minimumItems[money] > items) {
                        minimumItems[money] = items;
                        System.arraycopy(nextItemFree[money - prices[i]], 0, nextItemFree[money], 0, prices.length);
                        nextItemFree[money][i] = !nextItemFree[money][i];
                    }
                }
            }
        }

        return minimumItems;
    }
}
