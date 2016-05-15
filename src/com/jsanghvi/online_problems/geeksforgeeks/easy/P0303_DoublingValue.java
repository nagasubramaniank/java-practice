// Problem ID: 303. Doubling the value.
//
// Given an array of size n and an integer b, traverse the array and if the element in array is b, double b and continue
// traversal. In the end return value of b.
//
// Input:
// The first line of the input contains T denoting the number of test cases. Then follows the description of test cases.
// The first line of each test case contains two space separated positive integers n and b denoting the size of array
// and initial value of b respectively.The second line contains n space separated positive integers denoting the
// elements of array.
//
// Output:
// For each test case, print the final value of b.
//
// Constraints:
// 1 <= T <= 100
// 1 <= n <= 50
// 1 <= b <= 1000
// 1 <= A[i] <= 10^18 (1<=i<=N)
//
// Example:
// Input:
// 1
// 5 2
// 1 2 3 4 8
//
// Output:
// 16
//
// Explanation:
// The initial value of b is 2. Traversing from the first element, 2 is found in 2nd position, so doubling b we get
// b = 4 . 4 is found in 4th position so doubling b we get b = 8. 8 is found in 5th position, so doubling b we get
// b = 16.

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0303_DoublingValue {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int B = in.nextInt();
            final long[] A = new long[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextLong();
            }

            printFinalValue(A, B);
        }
    }

    private static void printFinalValue(long[] integers, int searchFor) {
        long nextSearchFor = searchFor;
        for (long integer : integers) {
            if (nextSearchFor == integer) {
                nextSearchFor *= 2;
            }
        }

        System.out.println(nextSearchFor);
    }
}
