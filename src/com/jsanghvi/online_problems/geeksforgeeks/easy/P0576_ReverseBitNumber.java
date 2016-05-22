// Problem ID: 576. Reverse bits.
//
// Reverse a 32 bit given number.
//
// Input:
// The first line of input consists number of the test cases. Each test case contains a single 32 bit integer.
//
// Output:
// Print the reverse of integer.
//
// Constraints:
// 1 <= T <= 100
// 0 <= x <= 4294967295
//
// Example:
//
// Input:
// 2
// 1
// 5
//
// Output:
// 2147483648
// 2684354560
//
// Explanation:
//
// In first case
// 00000000000000000000000000000001 = 1
// 10000000000000000000000000000000 = 2147483648

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0576_ReverseBitNumber {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printReversedBitNumber(in.nextLong());
        }
    }

    private static void printReversedBitNumber(final long number) {
        long remainingNumber = number, reversedNumber = 0;
        for (int i = 0; i < 32; i++) {
            reversedNumber = reversedNumber * 2 + (remainingNumber % 2);
            remainingNumber /= 2;
        }

        System.out.println(reversedNumber);
    }
}
