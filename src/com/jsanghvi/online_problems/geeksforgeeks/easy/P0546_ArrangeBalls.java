// Problem ID: 546. Arrange balls.
//
// There are ‘p’ balls of type P, ‘q’ balls of type Q and ‘r’ balls of type R. Using the balls we want to create a
// straight line such that no two balls of same type are adjacent.
//
// Input:
// First line of input contains number of test cases T. Each line of test case contains number of balls of each type
// separated by a single space.
//
// Output:
// Number of ways to arrange balls are displayed and 0 is displayed if there are no ways.
//
// Constraints:
// 1 <= T <= 30
// 1 <= p,q,r <= 9
//
// Example:
//
// Input:
// 2
// 2 2 2
// 1 1 1
//
// Output:
// 30
// 6

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0546_ArrangeBalls {
    private static final int[][][][] combinations = new int[3][10][10][10];

    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printTotalCombinations(in.nextInt(), in.nextInt(), in.nextInt());
        }
    }

    private static void printTotalCombinations(final int p, final int q, final int r) {
        for (int lasti = 0; lasti < 3; lasti++) {
            for (int pi = 0; pi < 10; pi++) {
                for (int qi = 0; qi < 10; qi++) {
                    for (int ri = 0; ri < 10; ri++) {
                        combinations[lasti][pi][qi][ri] = -1;
                    }
                }
            }
        }

        final int totalCombinations = countCombinations(0, p - 1, q, r) + countCombinations(1, p, q - 1, r)
                + countCombinations(2, p, q, r - 1);

        System.out.println(totalCombinations);
    }

    private static int countCombinations(final int last, final int p, final int q, final int r) {
        if (p < 0 || q < 0 || r < 0) {
            return 0;
        }

        if (p == 0 && q == 0 && r == 0) {
            return 1;
        }

        if (combinations[last][p][q][r] == -1) {
            if (last == 0) {
                combinations[last][p][q][r] = countCombinations(1, p, q - 1, r) + countCombinations(2, p, q, r - 1);
            } else if (last == 1) {
                combinations[last][p][q][r] = countCombinations(0, p - 1, q, r) + countCombinations(2, p, q, r - 1);
            } else if (last == 2) {
                combinations[last][p][q][r] = countCombinations(0, p - 1, q, r) + countCombinations(1, p, q - 1, r);
            }
        }

        return combinations[last][p][q][r];
    }
}
