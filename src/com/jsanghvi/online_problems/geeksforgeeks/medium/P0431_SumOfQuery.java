// Problem ID: 431. Sum of Query I.
//
// The Task is Simple. You need to calculate the following sum over Q queries.
//
// \sum_{i=l}^{r} (i-l+1) * (i-l+1) * arr[i]
//
// Assume array to be 1-Indexed.
//
// Input:
//
// The first line of  input contains the number of test cases.
// The second line of each test case contains the size of array.
// The third line of each test case contains the elements of array.
// The next line of each test case contains q queries  to be performed.
// The final line contains 2*q elements. The first element denoting L and the second element denoting R.
//
// Output:
//
// Print the required sum.
//
// Constraints:
//
// 1 <= T <= 10
// 1 <= N <= 1000
// 1 <= arr[i] <= 10000
// 1 <= Q <= 1000
// 1 <= L <= R <= N
//
// Example:
//
// Input:
// 1
// 7
// 2 3 4 5 1 6 7
// 4
// 1 7 2 4 2 6 3 7
//
// Output:
// 714 64 230 304

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0431_SumOfQuery {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            final int Q = in.nextInt();
            final int[] L = new int[Q];
            final int[] R = new int[Q];

            for (int i = 0; i < Q; i++) {
                L[i] = in.nextInt();
                R[i] = in.nextInt();
            }

            printSumOfQuery(A, L, R);
        }
    }

    private static void printSumOfQuery(final int[] array, final int lefts[], final int rights[]) {

        // We need to find X = Summation(l, r) (i - l + 1)^2 * ai.
        // To optimize the computation, we need to remove the variable term 'l' out of summation.
        // X can also be written as Summation(l, r) [i - (l - 1)]^2 * ai.
        // = Sum(l, r) i^2 ai  -  2(l - 2) Sum(l, r) i ai  +  (l - 1)^2 Sum(l, r) ai.
        // Let f2(i) = Sum(1, i) i^2 ai, f1(i) = Sum(1, i) i ai, and f0(i) = Sum(1, i) ai.
        // Then X = [f2(r) - f2(l-1)] - 2(l - 2)[f1(r) - f1(l-1)] + (l - 1)^2[f0(r) - f0(l-1)].

        long[] f2 = new long[array.length + 1], f1 = new long[array.length + 1], f0 = new long[array.length + 1];

        for (int i = 1; i <= array.length; i++) {
            f2[i] = f2[i - 1] + (long) i * i * array[i - 1];
            f1[i] = f1[i - 1] + (long) i * array[i - 1];
            f0[i] = f0[i - 1] + array[i - 1];
        }

        for (int i = 0; i < lefts.length; i++) {
            final int l = lefts[i], r = rights[i];
            final long answer = (f2[r] - f2[l - 1]) - 2 * (l - 1) * (f1[r] - f1[l - 1])
                    + (l - 1) * (l - 1) * (f0[r] - f0[l - 1]);
            System.out.print(answer + " ");
        }

        System.out.println();
    }
}
