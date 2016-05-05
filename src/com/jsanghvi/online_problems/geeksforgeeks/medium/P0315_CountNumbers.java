// Problem ID: Count Numbers in Range.
//
// Given two positive integers L and R, return count of numbers having exactly 3 divisors from L to R inclusive.
//
// Input:
//
// The first line of the input contains T denoting the number of test cases. Each of the next T lines contains two space
// separated positive integers denoting the values of L and R respectively.
//
// Output:
//
// For each test case, print the answer in a separate line.
//
// Constraints:
//
// 1 <= T <= 1000
// 1 <= L <= R <= 10^9
//
// Example:
//
// Input:
// 1
// 1 10
//
// Output:
// 2
//
// Explanation:
//
// In the given example, two numbers having exactly 3 divisors are 4 and 9.

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class P0315_CountNumbers {
    public static void main(final String[] args) {

        // All numbers have even number of divisors except for squares. Specifically, numbers with exactly three
        // divisors are square of prime numbers.

        NavigableMap<Integer, Integer> primeSquareRanks = getPrimeSquareRanks(1000000000);

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printCountNumbers(in.nextInt(), in.nextInt(), primeSquareRanks);
        }
    }

    private static NavigableMap<Integer, Integer> getPrimeSquareRanks(final int limit) {
        final boolean[] isNotPrime = new boolean[(int) Math.ceil(Math.sqrt((double) limit)) + 1];

        for (int number = 2; number * number < isNotPrime.length; number++) {
            if (!isNotPrime[number]) {
                for (int multiple = 2 * number; multiple < isNotPrime.length; multiple += number) {
                    isNotPrime[multiple] = true;
                }
            }
        }

        final NavigableMap<Integer, Integer> primeSquareRanks = new TreeMap<>();
        primeSquareRanks.put(0, 0);
        for (int rank = 1, number = 2; number < isNotPrime.length; number++) {
            if (!isNotPrime[number]) {
                primeSquareRanks.put(number * number, rank++);
            }
        }

        return primeSquareRanks;
    }

    private static void printCountNumbers(final int lowerLimit, final int upperLimit,
                                          final NavigableMap<Integer, Integer> primeSquareRanks) {
        System.out.println(primeSquareRanks.floorEntry(upperLimit).getValue()
                - primeSquareRanks.floorEntry(lowerLimit - 1).getValue());
    }
}
