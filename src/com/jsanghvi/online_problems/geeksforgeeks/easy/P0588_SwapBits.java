// Problem ID: 588. Swap bits.
//
// Given a number x and two positions (from right side) in binary representation of x, write a program that swaps n bits
// at given two positions and returns the result.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is X, P1, P2 and N. X is a number, P1 and P2 is two given position and swaps N
// number of bits at given two position.
//
// Output:
// Print the result.
//
// Constraints:
// 1 ≤ T ≤ 15
// 1 ≤ X ≤ 200
// 0 ≤ P1 < P2 ≤ 8
// 1 ≤ N ≤ 5
//
// Example:
//
// Input:
// 2
// 47 1 5 3
// 28 0 3 2
//
// Output:
// 227
// 7

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0588_SwapBits {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printSwappedBitsNumber(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
        }
    }

    private static void printSwappedBitsNumber(final int number, final int right, final int left, final int bitCount) {
        String binary = "0000000000000000" + Integer.toBinaryString(number);
        final String rightBinary = binary.substring(binary.length() - right - bitCount, binary.length() - right);
        final String leftBinary = binary.substring(binary.length() - left - bitCount, binary.length() - left);

        binary = binary.substring(0, binary.length() - right - bitCount) + leftBinary
                + binary.substring(binary.length() - right);

        binary = binary.substring(0, binary.length() - left - bitCount) + rightBinary
                + binary.substring(binary.length() - left);

        System.out.println(Integer.parseInt(binary, 2));
    }
}
