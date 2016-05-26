// Problem ID: Count numbers.
//
// Given a number n, write a program that returns count of numbers from 1 to n that don’t contain digit 3 in their
// decimal representation.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N.
//
// Output:
// Print the total numbers that don't contain digit 3.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 500
//
// Example:
//
// Input
// 2
// 10
// 45
//
// Output
// 9
// 31 // 3,13,23,30,31,32,33,34,35,36,37,38,39,43

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0597_NumbersWithoutThree {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printNumbersWithoutThree(in.nextInt());
        }
    }

    private static void printNumbersWithoutThree(final int number) {
        int numbersWithoutThree = number;
        numbersWithoutThree -= Math.min(Math.max(numbersWithoutThree - 299, 0), 100);
        numbersWithoutThree -= Math.min(Math.max((numbersWithoutThree % 100) - 29, 0), 10) + (numbersWithoutThree / 100) * 10;
        numbersWithoutThree -= Math.min(Math.max((numbersWithoutThree % 10) - 2, 0), 1) + (numbersWithoutThree / 10);
        System.out.println(numbersWithoutThree);
    }
}
