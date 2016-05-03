// Problem ID: 167. Along in couple.
//
// In a party everyone is in couple except one. People who are in couple have same numbers. Find out the person who is
// not in couple.
//
// Input:
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line
// contains an integer 'N' denoting the size of array. The second line contains N space-separated integers
// A1, A2, ..., AN denoting the elements of the array. (N is always odd)
//
// Output:
// In each separate line print number of the person not in couple.
//
// Constraints:
// 1 <= T <= 30
// 1 <= N <= 500
// 1 <= A[i] <= 500
// N % 2 == 1
//
// Example:
// Input:
// 1
// 5
// 1 2 3 2 1
//
// Output:
// 3

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0167_AloneInCouple {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printAloneMember(A);
        }
    }

    private static void printAloneMember(final int[] members) {

        int aloneMember = 0;
        for (int member : members) {
            aloneMember ^= member;
        }

        System.out.println(aloneMember);
    }
}
