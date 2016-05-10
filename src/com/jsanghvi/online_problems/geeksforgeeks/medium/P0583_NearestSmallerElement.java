// Problem ID: 583. Smallest number on left.
//
// Given an array of integers, find the nearest smaller number for every element such that the smaller element is on
// left side. If no small element present on the left print -1.
//
// Input:
//
// The first line of input contains T test cases.
// The first line of each test case contains the number of elements in the array.
// The second line of each test case contains the elements of the array.
//
// Output:
//
// Print the n elements.
//
// Constraints:
//
// 1 <= T <= 100
// 1 <= N <= 100
// 0 <= A[i] < 10000
//
// Example:
//
// Input:
// 2
// 3
// 1 6 2
// 6
// 1 5 0 3 4 5
//
// Output:
// -1 1 1
// -1 1 -1 0 3 4

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// Note: This program is optimized to meet geeksforgeeks expected time limit.

public class P0583_NearestSmallerElement {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokenizer = new StringTokenizer("");

    public static void main(final String[] args) throws IOException {
        final StringBuilder answers = new StringBuilder();

        final int T = nextInt();
        for (int test = 0; test < T; test++) {
            Stack<Integer> potentialElements = new Stack<>();
            potentialElements.push(-1);

            final int N = nextInt();
            for (int i = 0; i < N; i++) {
                final int element = nextInt();
                while (potentialElements.peek() >= element) {
                    potentialElements.pop();
                }

                answers.append(potentialElements.peek()).append(' ');
                potentialElements.push(element);
            }

            answers.append('\n');
        }

        System.out.print(answers);
    }

    private static int nextInt() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return Integer.parseInt(tokenizer.nextToken());
    }
}
