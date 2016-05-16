// Problem ID: 384. Next greater number set digits.
//
// Given a number n, find the smallest number that has same set of digits as n and is greater than n. If x is the
// greatest possible number with its set of digits, then print “not possible”.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is n,n is the number.
//
// Output:
//
// Print the greater number than n with same set of digits and if not possible then print "not possible" without double
// quote.
//
// Constraints:
//
// 1 ≤ T ≤ 100
// 1 ≤ n ≤ 100000
//
// Example:
//
// Input:
// 2
// 143
// 431
//
// Output:
// 314
// not possible

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0384_NextGreaterNumber {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printNextGreaterNumber(in.next());
        }
    }

    private static void printNextGreaterNumber(final String number) {
        final char[] digits = number.toCharArray();

        int i;
        for (i = digits.length - 2; i >= 0 && digits[i] >= digits[i + 1]; i--) ;

        if (i < 0) {
            System.out.println("not possible");
            return;
        }

        int j;
        for (j = digits.length - 1; digits[j] <= digits[i]; j--) ;
        swap(digits, i, j);
        reverse(digits, i + 1, digits.length - 1);

        for (char digit : digits) {
            System.out.print(digit);
        }
        System.out.println();
    }

    private static void swap(final char[] digits, final int index1, final int index2) {
        char temp = digits[index1];
        digits[index1] = digits[index2];
        digits[index2] = temp;
    }

    private static void reverse(final char[] digits, final int start, final int end) {
        for (int left = start, right = end; left < right; left++, right--) {
            swap(digits, left, right);
        }
    }
}
