// Problem ID: 174. Merge Two Sorted Array.
//
// You have to merge the two sorted arrays into one sorted array (in non-increasing order).
//
// Input:
//
// First line contains an integer T, denoting the number of test cases.
// First line of each test case contains two space separated integers X and Y, denoting the size of the two sorted arrays.
// Second line of each test case contains X space separated integers, denoting the first sorted array P.
// Third line of each test case contains Y space separated integers, denoting the second array Q.
//
// Output:
//
// For each test case, print (X + Y) space separated integer representing the merged array.
//
// Constraints:
//
// 1 <= T <= 100
// 1 <= X, Y <= 5*10^4
// 0 <= Pi, Qi <= 10^9
//
//
// Example:
//
// INPUT:
//
// 1
// 4 5
// 7 5 3 1
// 9 8 6 2 0
//
// OUTPUT:
//
// 9 8 7 6 5 3 2 1 0

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0174_MergeSortedArrays {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int X = in.nextInt(), Y = in.nextInt();
            final int[] P = new int[X + 1], Q = new int[Y + 1];

            for (int i = 0; i < X; i++) {
                P[i] = in.nextInt();
            }
            P[X] = Integer.MIN_VALUE;

            for (int i = 0; i < Y; i++) {
                Q[i] = in.nextInt();
            }
            Q[Y] = Integer.MIN_VALUE;

            printMergedArray(P, Q);
        }
    }

    private static void printMergedArray(final int[] array1, final int[] array2) {
        StringBuilder output = new StringBuilder();

        for (int index1 = 0, index2 = 0; index1 < array1.length - 1 || index2 < array2.length - 1; ) {
            if (array1[index1] > array2[index2]) {
                output.append(array1[index1++]).append(' ');
            } else {
                output.append(array2[index2++]).append(' ');
            }
        }

        System.out.println(output);
    }
}
