// Problem ID: 107. Adding One.
//
// Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ). The digits are stored such that the most significant digit is at the head of the list.
//
// Example:
//
// If the array has [4, 5, 6]
//
// the resultant array should be [4, 5, 7]
//
// as 456 + 1 = 457.
//
//
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
// The first line of each test case contains a single integer N denoting the size of array.
// The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
//
// Output:
//
// Print the space separated resultant array in a separate line for each case.
//
//
// Constraints:
//
// 1 ≤ T ≤ 30
// 1 ≤ N ≤ 1000
// 0 ≤ A[i] ≤ 9
//
//
// Example:
//
// Input:
// 2
// 4
// 5 6 7 8
// 3
// 9 9 9
// Output:
// 5 6 7 9
// 1 0 0 0

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0107_AddingOne {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printAddingOne(A);
        }
    }

    private static void printAddingOne(final int[] number) {
        int i;
        for (i = number.length - 1; i >= 0 && number[i] == 9; i--) {
            number[i] = 0;
        }

        StringBuilder numberPlusOne = new StringBuilder();
        if (i >= 0) {
            number[i] = number[i] + 1;
        } else {
            numberPlusOne.append("1 ");
        }

        for (i = 0; i < number.length; i++) {
            numberPlusOne.append(number[i]).append(' ');
        }

        System.out.println(numberPlusOne);
    }
}
