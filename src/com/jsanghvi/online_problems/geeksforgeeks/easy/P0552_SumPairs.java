// Problem ID: 552. Key pairs.
//
// Given an array A[] of n numbers and another number x, determine whether or not there exist two elements in A whose
// sum is exactly x.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N and X,N is the size of array.
// The second line of each test case contains N integers representing array elements C[i].
//
// Output:
// Print "Yes" if there exist two elements in A whose sum is exactly x, else "No" without quotes.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 200
// 1 ≤ C[i] ≤ 1000
//
// Example:
//
// Input:
// 2
// 6 16
// 1 4 45 6 10 8
// 5 10
// 1 2 4 3 6
//
// Output:
// Yes
// Yes

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P0552_SumPairs {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int X = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printPairExists(A, X);
        }
    }

    private static void printPairExists(final int[] numbers, final int sum) {
        Set<Integer> visitedNumbers = new HashSet<>();

        for (final int number : numbers) {
            if (visitedNumbers.contains(sum - number)) {
                System.out.println("Yes");
                return;
            }

            visitedNumbers.add(number);
        }

        System.out.println("No");
    }
}
