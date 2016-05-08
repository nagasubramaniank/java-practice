// Problem ID: 547. Sum of Query II.
//
// You are given an array and q queries which contains 2 positions in the array l and r. You need to compute the
// following sum over q queries. Array is 1-Indexed
//
// Input:
//
// The first line of input contains T test cases. The first line of each test case contains the number of elements in
// the array. The second line of each test case contains the elements of the array. The third line of each test case
// contains Q queries. The final line of each test case contains the 2 * Q elements where the first element contains
// l and second element contains r.
//
// Output:
//
// For each test case, print the required sum values in a single line separated by blank spaces. Print the output of
// each test case in a new line.
//
// Constraints:
//
// 1 <= T <= 100
// 1 <= N <= 1000
// 0 <= Arr[i] <= 10^6
// 1 <= Q <= 1000
// 1 <= l <= r <= N
//
// Example:
//
// Input:
// 1
// 4
// 1 2 3 4
// 2
// 1 4 2 3
//
// Output:
// 10 5

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Note: This program is optimized to meet geeksforgeeks expected time limit.

public class P0547_SumOfQuery {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokenizer = new StringTokenizer("");

    public static void main(final String[] args) throws IOException {
        final int[] sumTill = new int[1001];
        final int T = nextInt();

        for (int test = 0; test < T; test++) {
            final int N = nextInt();

            for (int i = 0; i < N; i++) {
                sumTill[i + 1] = sumTill[i] + nextInt();
            }

            final int Q = nextInt();
            final StringBuilder answers = new StringBuilder();

            for (int i = 0; i < Q; i++) {
                answers.append(-sumTill[nextInt() - 1] + sumTill[nextInt()]).append(' ');
            }

            System.out.println(answers);
        }
    }

    private static int nextInt() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return Integer.parseInt(tokenizer.nextToken());
    }
}
