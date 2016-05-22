// Problem ID: 539. Common elements in three arrays.
//
// Given three arrays sorted in non-decreasing order, print all common elements in these arrays.If there is no common element print -1.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. The description of T test cases
// follows.
// The first line of each test case contains three integers N1, N2 and N3 denoting the size of each array.
// Then three lines follow containing N1, N2 and N3 space-separated integers denoting the elements of each array.
//
// Output:
// Print all common elements in these arrays.If there is no common element print -1.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 100
// 0 ≤ A[i] <= 100
//
// Example:
//
// Input:
// 2
// 6 5 8
// 1 5 10 20 40 80
// 6 7 20 80 100
// 3 4 15 20 30 70 80 90
// 3 5 4
// 1 5 5
// 3 4 5 5 10
// 5 5 10 20
//
// Output:
// 20 80
// 5 5

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0539_CommonElements {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N1 = in.nextInt(), N2 = in.nextInt(), N3 = in.nextInt();
            final int[] A1 = new int[N1], A2 = new int[N2], A3 = new int[N3];

            for (int i = 0; i < N1; i++) {
                A1[i] = in.nextInt();
            }

            for (int i = 0; i < N2; i++) {
                A2[i] = in.nextInt();
            }

            for (int i = 0; i < N3; i++) {
                A3[i] = in.nextInt();
            }

            printCommonElements(A1, A2, A3);
        }
    }

    private static void printCommonElements(final int[] array1, final int[] array2, final int[] array3) {
        final int[][] elementCount = new int[101][3];

        for (final int element : array1) {
            elementCount[element][0] += 1;
        }

        for (final int element : array2) {
            elementCount[element][1] += 1;
        }

        for (final int element : array3) {
            elementCount[element][2] += 1;
        }

        for (int element = 0; element < elementCount.length; element++) {
            while (elementCount[element][0] > 0 && elementCount[element][1] > 0 && elementCount[element][2] > 0) {
                System.out.print(element + " ");
                elementCount[element][0] -= 1;
                elementCount[element][1] -= 1;
                elementCount[element][2] -= 1;
            }
        }

        System.out.println();
    }
}
