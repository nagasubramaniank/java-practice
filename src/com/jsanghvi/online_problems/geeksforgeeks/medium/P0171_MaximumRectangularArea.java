// Problem ID: 171. Maximum Rectangular Area in a Histogram.
//
// Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number
// of contiguous bars. For simplicity, assume that all bars have same width and the width is 1 unit.
//
// Input:
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line
// contains an integer 'N' denoting the size of array. The second line contains N space-separated integers
// A1, A2, ..., AN denoting the elements of the array. The elements of the array represents the height of the bars.
//
// Output:
// In each separate line the maximum rectangular area possible from the contiguous bars.
//
// Constraints:
// 1 <= T <= 30
// 1 <= N <= 100
// 1 <= A[i] <= 1000
//
// Example:
// Input:
// 1
// 7
// 6 2 5 4 5 1 6
//
// Output:
// 12

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;
import java.util.Stack;

public class P0171_MaximumRectangularArea {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();

            // Add a dummy node to end of histogram to simplify the algorithm.
            final int[] A = new int[N + 1];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printMaximumArea(A);
        }
    }

    private static void printMaximumArea(final int[] histogram) {

        int maximumArea = 0;
        final Stack<Integer> stack = new Stack<>();

        for (int index = 0; index < histogram.length; index++) {
            while (!stack.empty() && histogram[stack.peek()] >= histogram[index]) {

                final int height = histogram[stack.pop()];
                final int width = stack.empty() ? index : index - stack.peek() - 1;
                final int area = height * width;

                maximumArea = Math.max(maximumArea, area);
            }

            stack.push(index);
        }

        System.out.println(maximumArea);
    }
}
