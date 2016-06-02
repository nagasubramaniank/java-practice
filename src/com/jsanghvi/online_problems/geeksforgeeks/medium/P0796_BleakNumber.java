// Problem ID: 796. Bleak numbers.
//
// Given an integer, check whether it is Bleak or not. A number ‘n’ is called Bleak if it cannot be represented as sum
// of a positive number x and set bit count in x, i.e., x + countSetBits(x) is not equal to n for any non-negative
// number x.
//
// Examples :
//
// 3 is not Bleak as it can be represented as 2 + countSetBits(2).
// 4 is t Bleak as it cannot be represented as sum of a number x and countSetBits(x) for any number x.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test
// case consists of a single line. The first line of each test case contains a single integer N to be checked for
// palindrome.
//
// Output:
// Print "1" or "0" (without quotes) depending on whether the number is Bleak or not.
//
// Constraints:
// 1 <= T <= 1000
// 1 <= N <= 10000
//
// Example:
// Input:
// 3
// 4
// 167
// 3
//
// Output:
// 1
// 0
// 0

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0796_BleakNumber {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printIsBleakNumber(in.nextInt());
        }
    }

    private static void printIsBleakNumber(final int number) {
        for (int x = number - (int) Math.ceil(Math.log(number) / Math.log(2)); x < number; x++) {
            if (x + countSetBits(x) == number) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }

    private static int countSetBits(int number) {
        number = (number & 0x55555555) + ((number >>> 1) & 0x55555555);
        number = (number & 0x33333333) + ((number >>> 2) & 0x33333333);
        number = (number & 0x0F0F0F0F) + ((number >>> 4) & 0x0F0F0F0F);
        number = (number & 0x00FF00FF) + ((number >>> 8) & 0x00FF00FF);
        number = (number & 0x0000FFFF) + ((number >>> 16) & 0x0000FFFF);

        return number;
    }
}
