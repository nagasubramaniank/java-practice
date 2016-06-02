// Problem ID: 714. Filling bucket.
//
// Given a Bucket having a capacity of N litres and the task is to determine that by how many ways you can fill it using
// two bottles of capacity of 1 Litre and 2 Litre only. Give the answer in Modulo 10^9.
//
// Input
// The first line contains an integer T denoting the number of test cases. Then T test cases follow. Each test case
// consists of a single line containing  an integer N, where N denotes the capacity of the Bucket.
//
// Output
// For each test case print in a new line the total number of ways in which the Bucket can be filled.
//
// Constraints:
// 1 ≤ T ≤ 500
// 1 ≤ N ≤ 1000
//
// Input
// 2
// 3
// 4
//
// Output
// 3
// 5
//
// Explanation
// Let O denote filling by 1 litre bottle  and T denote filling by 2 litre bottle. So we have :
// For N=3 {OOO,TO,OT} thus there are 3 total ways.
// For N=4 {TT,OOOO,TOO,OTO,OOT} thus there are 5 total ways.

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0714_FillingCombinations {
    public static void main(final String[] args) {
        final int[] fillingCombinations = getFillingCombinations(1000);

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printFillingCombinations(in.nextInt(), fillingCombinations);
        }
    }

    private static void printFillingCombinations(final int bucketSize, final int[] fillingCombinations) {
        System.out.println(fillingCombinations[bucketSize]);
    }

    private static int[] getFillingCombinations(final int maximumBucketSize) {
        final int[] fillingCombinations = new int[maximumBucketSize + 1];

        fillingCombinations[0] = 1;
        fillingCombinations[1] = 1;
        for (int bucketSize = 2; bucketSize <= maximumBucketSize; bucketSize++) {
            fillingCombinations[bucketSize] =
                    (fillingCombinations[bucketSize - 1] + fillingCombinations[bucketSize - 2]) % 1000000000;
        }

        return fillingCombinations;
    }
}
