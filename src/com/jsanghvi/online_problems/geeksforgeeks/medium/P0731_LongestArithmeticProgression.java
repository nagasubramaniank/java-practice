// Problem ID: 731. Longest arithmetic progression.
//
// Given an array of sorted numbers, write a program to find the length of the Longest Arithmetic Progression in it.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test
// case consists of two lines.
// The first line of each test case contains an integer N, where  N is the size of array.
// The second line of each test case contains N space separated integers denoting array input A[i].
//
// Output:
// Print the length of the Longest Arithmetic Progression ​
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 1000
// 1 <= arr[i] <= 1000
//
// Example:
//
// Input:
// 2
// 6
// 1 7 10 13 14 19
// 5
// 2 4 6 8 10
//
// Output:
// 4
// 5
//
// Explanation:
// For test case 1:
// set[] = {1, 7, 10, 15, 27, 29}
// output = 3
// The longest arithmetic progression is {1, 15, 29}
// For test case 2:
// set[] = {2, 4, 6, 8, 10}
// output = 5
// The whole set is in arithmetic progression.

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P0731_LongestArithmeticProgression {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printLongestArithmeticProgression(A);
        }
    }

    private static void printLongestArithmeticProgression(final int[] numbers) {

        // progressionLengths[i][j] will contain length of longest progressions with numbers[i] as second-to-last
        // element and numbers[j] as last element.
        final int[][] progressionLengths = new int[numbers.length][numbers.length];
        final Map<Integer, Integer> indexOf = new HashMap<>();
        int longestProgressionLength = 1;

        for (int secondLastIndex = 0; secondLastIndex < progressionLengths.length; secondLastIndex++) {
            for (int lastIndex = secondLastIndex + 1; lastIndex < progressionLengths.length; lastIndex++) {
                int thirdLastNumber = 2 * numbers[secondLastIndex] - numbers[lastIndex];
                progressionLengths[secondLastIndex][lastIndex] = (indexOf.containsKey(thirdLastNumber)
                        ? progressionLengths[indexOf.get(thirdLastNumber)][secondLastIndex] : 1) + 1;

                longestProgressionLength
                        = Math.max(longestProgressionLength, progressionLengths[secondLastIndex][lastIndex]);
            }
            indexOf.put(numbers[secondLastIndex], secondLastIndex);
        }

        System.out.println(longestProgressionLength);
    }
}
