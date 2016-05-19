// Problem ID: 477. Kth distance.
//
// Given an unsorted array that may contain duplicates. Also given a number k which is smaller than size of array. Write
// a function that returns true if array contains duplicates within k distance.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is K and N; K is the distance and N is the size of array.
// The second line of each test case contains N input A[].
//
// Output:
// Print True if array contains duplicates within k distance else False.
//
// Constraints:
// 1 ≤ T ≤ 50
// 1 ≤ N ≤ 100
// 1 ≤ K ≤ N
// 1 ≤ A[] ≤ 1000
//
// Example:
//
// Input:
// 4
// 3 8
// 1 2 3 4 1 2 3 4
// 3 6
// 1 2 3 1 4 5
// 3 5
// 1 2 3 4 5
// 3 5
// 1 2 3 4 4
//
// Output:
// False
// True
// False
// True

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P0477_DuplicatesInDistance {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int K = in.nextInt();
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printDuplicatesInDistance(A, K);
        }
    }

    private static void printDuplicatesInDistance(final int[] array, final int distance) {

        // It is not required to keep counts of numbers. We can safely remove array[i - distance - 1] element, since if
        // multiple elements with same values existed in previous subarray, we would have already exited the function
        // with 'True' result.

        final Set<Integer> lastNumbers = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            if (i > distance) {
                lastNumbers.remove(array[i - distance - 1]);
            }

            if (lastNumbers.contains(array[i])) {
                System.out.println("True");
                return;
            }

            lastNumbers.add(array[i]);
        }

        System.out.println("False");
    }
}
