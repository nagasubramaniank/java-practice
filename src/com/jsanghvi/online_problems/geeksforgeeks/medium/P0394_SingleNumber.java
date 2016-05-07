package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0394_SingleNumber {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printSingleNumber(A);
        }
    }

    private static void printSingleNumber(final int[] numbers) {

        int singleNumber = 0;
        for (int number : numbers) {
            singleNumber ^= number;
        }

        System.out.println(singleNumber);
    }
}
