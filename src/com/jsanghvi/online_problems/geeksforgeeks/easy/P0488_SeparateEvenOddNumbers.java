// Problem ID: 488. Segregate even and odd numbers.
//
// Given an array A[], write a program that segregates even and odd numbers. The program should put all even numbers
// first in sorted order, and then odd numbers in sorted order.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. The description of T test cases
// follows. The first line of each test case contains a single integer N denoting the size of array. The second line
// contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
//
// Output:
// Print the segregated array.
//
// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 100
// 0 ≤ A[i] <= 1000
//
// Example:
//
// Input:
// 2
// 7
// 12 34 45 9 8 90 3
// 5
// 0 1 2 3 4
//
// Output:
// 8 12 34 90 3 9 45
// 0 2 4 1 3

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P0488_SeparateEvenOddNumbers {
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
        List<Integer> evenNumbers = new ArrayList<>(), oddNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }
        }

        Collections.sort(evenNumbers);
        Collections.sort(oddNumbers);
        StringBuilder output = new StringBuilder();

        for (int number : evenNumbers) {
            output.append(number).append(' ');
        }

        for (int number : oddNumbers) {
            output.append(number).append(' ');
        }

        System.out.println(output);
    }
}
