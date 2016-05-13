// Problem ID: Magic Number
//
// A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5. First few
// magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ....
//
// Given the value of n. find the nth Magic number.
//
// Input:
//
// The first line contains an integer T, depicting total number of test cases.
// Then following T lines contains an integer N depicting the value of N.
//
// Output:
//
// Print the nth magic number in a separate line.
//
// Constraints:
//
// 1 ≤ T ≤ 30
// 1 ≤ N ≤ 100
//
// Example:
//
// Input:
// 2
// 1
// 2
// Output:
// 5
// 25

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0176_MagicNumber {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printMagicNumber(in.nextInt());
        }
    }

    private static void printMagicNumber(final int orderNumber) {

        int magicNumber = 0;
        for (int multiple = 5, number = orderNumber; number > 0; multiple *= 5, number /= 2) {
            magicNumber += (number % 2) * multiple;
        }

        System.out.println(magicNumber);
    }
}
