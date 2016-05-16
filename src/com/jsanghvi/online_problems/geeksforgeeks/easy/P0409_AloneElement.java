// Problem ID: 409. Element that appears once where every element occurs twice.
//
// Given an array of integers, every element appears twice except for one. Find that single one in linear time
// complexity and without using extra memory.
//
// Input:
// The first line of input consists number of the test cases. The description of T test cases is as follows:
// The first line of each test case contains the size of the array, and the second line has the elements of the array.
//
// Output:
// In each separate line print the number that appears only once in the array.
//
// Constraints:
// 1 ≤ T ≤ 70
// 1 ≤ N ≤ 100
// 0 ≤ A[i] ≤ 100000
//
// Example:
//
// Input:
// 1
// 11
// 1 2 4 3 3 2 5 6 1 6 5
//
// Output:
// 4

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Note: This program is optimized to meet geeksforgeeks expected time limit.

public class P0409_AloneElement {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokenizer = new StringTokenizer("");

    public static void main(final String[] args) throws IOException {
        final int T = nextInt();

        for (int test = 0; test < T; test++) {
            final int N = nextInt();
            int aloneElement = 0;

            for (int i = 0; i < N; i++) {
                aloneElement ^= nextInt();
            }

            System.out.println(aloneElement);
        }
    }

    private static int nextInt() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return Integer.parseInt(tokenizer.nextToken());
    }
}
