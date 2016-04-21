// Problem ID: 590. Subarray with given sum.
//
// Given an unsorted array of non-negative integers, find a continuous sub-array which adds to a given number.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N and S, N is the size of array and S in sum.
// The second line of each test case contains N input C[i].
//
// Output:
//
// Print the first such occurring sub-array a[i] and a[j] if sum equal to sub-array else print -1.
//
// Constraints:
//
// 1 ≤ T ≤ 50
// 1 ≤ N ≤ 100
// 1 ≤ C[i] ≤ 200
//
// Example:
//
// Input:
// 2
// 5 12
// 1 2 3 7 5
// 10 15
// 1 2 3 4 5 6 7 8 9 10
//
// Output:
// 2 4
// 1 5
//
// Explanation :
// In first test case, sum of elements from 2nd position to 4th position is 12
// In second test case, sum of elements from 1st position to 5th position is 15

package com.jsanghvi.online_problems.geeksforgeeks;

import java.util.Scanner;

public class SubarrayWithSum {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int S = in.nextInt();

            final int[] C = new int[N];
            for (int i = 0; i < N; i++) {
                C[i] = in.nextInt();
            }

            printSubarrayIndices(C, S);
        }
    }

    private static void printSubarrayIndices(final int[] array, final int sum) {
        if (sum > 0) {
            for (int startIndex = 0, endIndex = 0, currentSum = array[startIndex]; ; ) {
                if (currentSum < sum) {
                    if (endIndex >= array.length - 1) break;
                    currentSum += array[++endIndex];
                } else if (currentSum > sum) {
                    if (startIndex >= array.length) break;
                    currentSum -= array[startIndex++];
                } else {
                    System.out.println((startIndex + 1) + " " + (endIndex + 1));
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}
