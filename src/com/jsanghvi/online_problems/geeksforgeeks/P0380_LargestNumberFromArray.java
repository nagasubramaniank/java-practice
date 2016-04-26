// Problem ID: 380. Largest Number formed from an Array.
//
// Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.
//
// The result is going to be very large, hence return the result in the form of a string.
//
// Input:
//
// The first line of input consists number of the test cases. The description of T test cases is as follows:
//
// The first line of each test case contains the size of the array, and the second line has the elements of the array.
//
// Output:
//
// In each separate line print the largest number formed by arranging the elements of the array in the form of a string.
//
// Constraints:
//
// 1 ≤ T ≤ 70
// 1 ≤ N ≤ 100
// 0 ≤ A[i] ≤ 1000
//
// Example:
//
// Input:
//
// 2
// 5
// 3 30 34 5 9
// 4
// 54 546 548 60
//
// Output:
//
// 9534330
// 6054854654

package com.jsanghvi.online_problems.geeksforgeeks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P0380_LargestNumberFromArray {

    private static final LargestNumberComparator comparator = new LargestNumberComparator();

    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final Integer[] A = new Integer[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printLargestNumber(A);
        }
    }

    private static void printLargestNumber(final Integer[] array) {
        Arrays.sort(array, comparator);

        for (int element : array) {
            System.out.print(element);
        }

        System.out.println();
    }

    private static class LargestNumberComparator implements Comparator<Integer> {
        /*
        @Override
        public int compare(final Integer num1, final Integer num2) {
            final String str1 = num1.toString();
            final String str2 = num2.toString();

            int length = Math.max(str1.length(), str2.length());

            // Need to compare one more character that we would expect.
            // For example, 12 should be placed before 121. Similarly, 21 should be placed after 212.
            for (int i = 0; i <= length; i++) {
                int difference = str2.charAt(i % str2.length()) - str1.charAt(i % str1.length());
                if (difference != 0) {
                    return difference;
                }
            }

            return 0;
        }
        */

        @Override
        public int compare(final Integer num1, final Integer num2) {
            return new Integer(String.valueOf(num2) + String.valueOf(num1)).compareTo(
                    new Integer(String.valueOf(num1) + String.valueOf(num2)));
        }
    }
}
