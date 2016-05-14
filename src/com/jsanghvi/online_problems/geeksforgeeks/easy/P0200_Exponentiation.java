// Problem ID: 200. a^b (Set 2)
//
// For two given positive numbers a and b. Find a^b. Output your number modulus 10^9+7.
//
// Input:
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, there are two
// numbers a and b.
//
// Output:
// Find a^b.
//
// Constraints:
// 1 <= T <= 31
// 1 <= a <= 100
// 1 <= b <= 1000000
//
// Example:
// Input:
// 2
// 1 1
// 2 5
//
// Output:
// 1
// 32

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0200_Exponentiation {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printExponentiation(in.nextInt(), in.nextInt());
        }
    }

    private static void printExponentiation(final int number, final int exponent) {
        long currentMultiple = number;
        long result = 1;

        for (int i = 0; i < 20; i++) {
            if ((exponent & (1 << i)) != 0) {
                result = (result * currentMultiple) % 1000000007;
            }
            currentMultiple = (currentMultiple * currentMultiple) % 1000000007;
        }

        System.out.println(result);
    }
}
