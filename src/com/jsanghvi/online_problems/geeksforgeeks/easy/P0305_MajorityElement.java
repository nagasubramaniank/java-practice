// Problem ID: 305. Majority Element.
//
// Write a program to find the majority element in the array. A majority element in an array A[] of size n is an element
// that appears more than n/2 times (and hence there is at most one such element).  If input array doesn't contain a
// majority element, then output "NO Majority Element"
//
// Input:
// The first line of the input contains T denoting the number of test cases. The first line of the test case will be the
// size of array and second line will be the elements of the array.
//
// Output:
// For each test case the output will be the majority element of the array.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 100
// 0 <= a[i] <= 100
//
// Example:
//
// Input:
// 2
// 5
// 3 1 3 3 2
// 3
// 1 2 3
//
// Output:
// 3
// NO Majority Element

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0305_MajorityElement {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printMajorityElement(A);
        }
    }

    private static void printMajorityElement(final int[] elements) {
        int[] counts = new int[101];

        for (int element : elements) {
            counts[element] += 1;
        }

        for (int element = 0; element < counts.length; element++) {
            if (counts[element] > elements.length / 2) {
                System.out.println(element);
                return;
            }
        }

        System.out.println("NO Majority Element");
    }
}
