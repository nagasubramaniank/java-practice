// Problem ID: 258. First Repeating Element.
//
// Find the first repeating element in an array of integers and whose index of first occurrence is smallest.
//
// Input :
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, First line is
// number of elements in array 'N' and second its values.
//
// Output: 
// In each separate line print the index of first repeating element, if there is not any repeating element then print
// “-1”. Use 1 Based Indexing.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 10000
// 0 <= a[i] <= 10000
//
// Example:
// Input:
// 1
// 7
// 1 5 3 4 3 5 6
//
// Output:
// 2
//
// Explanation:
// 5 is appearing twice and its first appearance is at index 2 which is less than 3 whose first occurring index is 3.

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0258_FirstRepeatingElement {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printFirstRepeatingElement(A);
        }
    }

    private static void printFirstRepeatingElement(final int[] array) {
        final boolean[] elementExists = new boolean[10001];
        int firstRepeatingElementIndex = -2;

        for (int index = array.length - 1; index >= 0; index--) {
            if (elementExists[array[index]]) {
                firstRepeatingElementIndex = index;
            } else {
                elementExists[array[index]] = true;
            }
        }

        System.out.println(firstRepeatingElementIndex + 1);
    }
}
