// Problem ID: 725. Fill up buckets.
//
// There are N buckets. The task is to assign a certain number of balls to each bucket. Each bucket should have at least
// one ball. The capacity of each bucket is provided in an array MAX. For the ith bucket, the capacity is MAX[i] and the
// number of balls to be assigned to the ith bucket is between 1 to MAX[i] both bounds inclusive. All buckets should
// have distinct number of balls. Output "the number of ways in which the N buckets can be filled" modulo 10^9+7.
//
// Input:
// First line of the input contains a single integer T denoting the number of test cases. Then T test cases follow. Each
// test case consists of two lines. First line of each test case consists of an integer - N denoting the number of
// buckets. Second line of each test case consists of N space separated integers of  array MAX[] denoting the maximum
// capacity of each bucket.
//
// Output:
// For each test case, output the required answer in a separate line.
//
// Constraints:
// 1 ≤ T ≤ 20
// 1 ≤ N ≤ 1000
// 1 ≤ MAX[k] ≤ 1000 for k=1,2..N
//
// Example:
// Input
// 2
// 1
// 6
// 2
// 5 8
//
// Output
// 6
// 35
//
// Explanation
// For the first example, the single bucket can be assigned any number between 1 and 6, inclusive, hence 6 ways.

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Arrays;
import java.util.Scanner;

public class P0725_FillBuckets {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printTotalFillPositions(A);
        }
    }

    private static void printTotalFillPositions(final int[] capacities) {
        Arrays.sort(capacities);

        // The result will be zero if no fill position is possible. Since, the array is sorted, we will always hit a
        // condition where capacities[i] == i before capacities[i] < i, hence it is impossible to obtain a negative
        // fillPosition value.

        long fillPositions = 1;
        for (int i = 0; i < capacities.length; i++) {
            fillPositions = (fillPositions * (capacities[i] - i)) % 1000000007;
        }

        System.out.println(fillPositions);
    }
}
