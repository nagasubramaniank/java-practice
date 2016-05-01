// Problem ID: 131. Equal Sum.
//
// Given an array A of length N. Determine if there exists an element in the array such that the sum of the elements on
// its left is equal to the sum of the elements on its right. If there are no elements to the left/right, then the sum
// is considered to be zero. Formally, find an i, such that, A1+A2...Ai-1 = Ai+1+Ai+2...AN.
//
// Input:
//
// The first line contains T, the number of test cases. For each test case, the first line contains N, the number of
// elements in the array A. The second line for each test case contains N space-separated integers, denoting the array A.
//
// Output:
//
// For each test case print YES if there exists an element in the array, such that the sum of the elements on its left
// is equal to the sum of the elements on its right; otherwise print NO in a separate line.
//
// Constraints:
//
// 1 ≤ T ≤ 30
// 1 ≤ N ≤100000
// 1 ≤ Ai ≤ 2×10000
// 1 ≤ i ≤N
//
// Example:
//
// Input
// 1
// 4
// 1 2 3 3
//
// Output:
// YES

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0131_EqualSum {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printIsEqualSum(A);
        }
    }

    private static void printIsEqualSum(int[] array) {
        int totalSum = 0;
        for (int number : array) {
            totalSum += number;
        }

        int leftSum = 0;
        for (int number : array) {
            final int rightSum = totalSum - leftSum - number;

            if (leftSum == rightSum) {
                System.out.println("YES");
                return;
            }

            leftSum += number;
        }

        System.out.println("NO");
    }
}
