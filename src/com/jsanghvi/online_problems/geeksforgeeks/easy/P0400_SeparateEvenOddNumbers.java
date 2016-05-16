// Problem ID: 400. Segregate even and odd nodes in a Linked List.
//
// Given a Linked List of integers, write a function to modify the linked list such that all even numbers appear before
// all the odd numbers in the modified linked list. Also, keep the order of even and odd numbers same.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N,N is the number of elements in Linked List.
// The second line of each test case contains N input,elements in Linked List.
//
// Output:
// Print the all even numbers then odd numbers in the modified Linked List.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 100
// 1 ≤ size of elements ≤ 1000
//
// Example:
//
// Input:
// 3
// 7
// 17 15 8 9 2 4 6
// 4
// 1 3 5 7
// 7
// 8 12 10 5 4 1 6
//
// Output:
// 8 2 4 6 17 15 9
// 1 3 5 7
// 8 12 10 4 6 5 1

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0400_SeparateEvenOddNumbers {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printEvenOddNumbers(A);
        }
    }

    private static void printEvenOddNumbers(final int[] numbers) {
        StringBuilder output = new StringBuilder();

        for (int number : numbers) {
            if (number % 2 == 0) {
                output.append(number).append(' ');
            }
        }

        for (int number : numbers) {
            if (number % 2 != 0) {
                output.append(number).append(' ');
            }
        }

        System.out.println(output);
    }
}
