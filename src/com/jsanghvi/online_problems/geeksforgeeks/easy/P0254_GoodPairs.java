// Problem ID: 254. Good Pairs.
//
// You are given an array of positive integer numbers a1,a2...aN. Count number of pairs (i,j) such that:
// 1 ≤ i ≤ N
// 1 ≤ j ≤ N
// ai < aj
//
// Input:
// The first line contains 'T' denoting the number of test cases. Then follows description of test cases. Each case
// begins with a single positive integer N denoting the size of array.The second line contains N space separated
// positive integers denoting the elements of array.
//
// Output:
// For each test case, output a single line containing number of pairs for corresponding test case.
//
// Constraints:
// 1 <= T <= 20
// 1 <= N <= 10^3
// 1 <= a[i] <= 10^3
//
// Example:
//
// Input:
// 2
// 2
// 2 1
// 3
// 2 3 2
//
// Output:
// 1
// 2
//
// Explanation:
// In the first test case, the only good pair is (2,1).
// In the second test case, the two good pairs are (2,3) and (3,2)

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0254_GoodPairs {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printGoodPairs(A);
        }
    }

    private static void printGoodPairs(final int[] array) {
        final int[] counts = new int[1001];
        for (int number : array) {
            counts[number] += 1;
        }

        int pairs = 0;
        for (int count : counts) {
            if (count > 0) {
                pairs += count * (array.length - count);
            }
        }

        System.out.println(pairs / 2);
    }
}
