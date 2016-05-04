// Problem ID: 256. Next Smallest Palindrome.
//
// Given a number, find the next smallest palindrome.
//
// Input :
//  The first line is number of test cases, second is size of array, third line contains digits of number with spaces in
// between. The input is assumed to be an array. Every entry in array represents a digit in input number. Let the array
// be ‘num[]’ and size of array be ’n’. Size of the number can be up to 1000 digits.
//
// Output:
//  In each separate line print the digits of palindrome with spaces in between.
//
// Constraints: 
// 1 <= T <= 100
// 1 <= n <= 1000
// 1 <= a[i] <= 9
//
// Example: 
// Input: 
// 1
// 11
// 9 4 1 8 7 9 7 8 3 2 2
//
// Output: 
// 9 4 1 8 8 0 8 8 1 4 9

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P0256_NextSmallestPalindrome {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();

            List<Integer> A = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                A.add(in.nextInt());
            }

            printNextSmallestPalindrome(A);
        }
    }

    private static void printNextSmallestPalindrome(final List<Integer> number) {
        getSmallestPalindrome(number, true);

        for (int digit : number) {
            System.out.print(digit + " ");
        }
        System.out.println();
    }

    private static void getSmallestPalindrome(final List<Integer> number, final boolean findNext) {
        int size = number.size();

        // Scan the number in both directions from mid point.
        int left, right;
        for (left = (size - 2) / 2, right = (size + 1) / 2; right < size && number.get(left).equals(number.get(right));
             left--, right++)
            ;

        // If we reached the end of number, or found a right digit greater than left digit.
        if (findNext && (right == size || number.get(right) > number.get(left))) {

            // Make right digit same as right digit, increment the number starting with position before right digit.
            if (right < size) {
                number.set(right, number.get(left));
            }

            int i;
            for (i = right - 1; i >= 0 && number.get(i) == 9; i--) {
                number.set(i, 0);
            }

            // Check if need to increase the size of number.
            if (i < 0) {
                number.add(0, 1);
                size += 1;
            } else {
                number.set(i, number.get(i) + 1);
            }

            // Convert the number to palindrome only if it has more than one digits.
            if (size > 1) {
                getSmallestPalindrome(number, false);
                return;
            }
        }

        // Normal case. Set all right digits equal to left digits of number.
        for (; right < size; right++, left--) {
            number.set(right, number.get(left));
        }
    }
}
