// Problem ID: 401. Modular Exponentiation for large numbers.
//
// Implement pow(A, B) % C. In other words, given A, B and C, find (A^B) % C.
//
// Input:
// The first line of input consists number of the test cases.
// The following T lines consist of 3 numbers each separated by a space and in the following order:
// A B C
// 'A' being the base number, 'B' the exponent (power to the base number) and 'C' the modular.
//
// Output:
// In each separate line print the modular exponent of the given numbers in the test case.
//
// Constraints:
// 1 ≤ T ≤ 70
// 1 ≤ A ≤ 10^5
// 1 ≤ B ≤ 10^5
// 1 ≤ C ≤ 10^5
//
// Example:
//
// Input:
// 3
// 3 2 4
// 10 9 6
// 450 768 517
//
// Output:
// 1
// 4
// 34

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0401_ModularExponentiation {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printExponentiation(in.nextInt(), in.nextInt(), in.nextInt());
        }
    }

    private static void printExponentiation(final int A, final int B, final int C) {
        int remainingExponent = B, currentMultiple = A % C;
        int result = 1;

        for (int i = 0; remainingExponent != 0; i++) {
            if ((remainingExponent & (1 << i)) != 0) {
                result = (result * currentMultiple) % C;
                remainingExponent &= ~(1 << i);
            }
            currentMultiple = (currentMultiple * currentMultiple) % C;
        }

        System.out.println(result);
    }
}
