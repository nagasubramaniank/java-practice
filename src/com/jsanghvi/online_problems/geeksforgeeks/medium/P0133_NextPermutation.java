// Problem ID: 133. Next Permutation.
//
// Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers. If
// such arrangement is not possible, it must be rearranged as the lowest possible order i.e., sorted in an ascending
// order.
//
// For example:
//
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
//
// Input:
//
// The first line contains an integer T, depicting total number of test cases. Then following T lines contains an
// integer N depicting the size of array and next line followed by the value of array.
//
// Output:
//
// Print the array of next permutation in a separate line.
//
// Constraints:
//
// 1 ≤ T ≤ 40
// 1 ≤ N ≤ 100
// 0 ≤ A[i] ≤ 100
//
// Example:
//
// Input
// 1
// 6
// 1 2 3 6 5 4
//
// Output
// 1 2 4 3 5 6

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0133_NextPermutation {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printNextPermutation(A);
        }
    }

    private static void printNextPermutation(final int[] array) {

        int i;
        for (i = array.length - 2; i >= 0 && array[i] >= array[i + 1]; i--) ;

        if (i >= 0) {
            int j;
            for (j = array.length - 1; array[j] <= array[i]; j--) ;
            swap(array, i, j);
        }

        reverse(array, i + 1, array.length - 1);

        for (i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    private static void swap(final int[] array, final int index1, final int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void reverse(final int[] array, final int start, final int end) {
        for (int left = start, right = end; left < right; left++, right--) {
            swap(array, left, right);
        }
    }
}
