// Problem ID: 283. Pythagorean Triplet.
//
// Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2
// = c2.
//
// Input:
// The first line contains 'T' denoting the number of test cases. Then follows description of test cases.
// Each case begins with a single positive integer N denoting the size of array.
// The second line contains the N space separated positive integers denoting the elements of array A.
//
// Output:
// For each test case, print "Yes" or  "No" whether it is Pythagorean Triplet or not.
//
// Constraints:
// 1 <= T <= 50
// 1 <= N <= 100
// 1 <= A[i] <= 100
//
// Example:
// Input:
// 1
// 5
// 3 2 4 6 5
//
// Output:
// Yes

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Arrays;
import java.util.Scanner;

public class P0283_PythagoreanTriplets {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printPythagoreanTripletExits(A);
        }
    }

    private static void printPythagoreanTripletExits(final int[] integers) {
        Integer[] squares = new Integer[integers.length];

        for (int i = 0; i < integers.length; i++) {
            squares[i] = integers[i] * integers[i];
        }

        Arrays.sort(squares);

        for (int hypotenuse = squares.length - 1; hypotenuse >= 0; hypotenuse--) {
            for (int left = 0, right = hypotenuse - 1; left < right; ) {
                if (squares[left] + squares[right] < squares[hypotenuse]) {
                    left += 1;
                } else if (squares[left] + squares[right] > squares[hypotenuse]) {
                    right -= 1;
                } else {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }
}
