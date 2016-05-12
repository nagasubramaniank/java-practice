// Problem ID: Dimensions of Rectangle.
//
// You are required to build some sheets of rectangular shape of Area A. To build a sheet of an  Area A of Dimensions L
// & B. You have two conditions:
//
// 1. L and B can not be in decimals.
// 2. When L and B are even, L must be Equal to B.
//
// Calculate the number of possible choices to build a sheet of area A
//
// Input:
// First line contains the number of test-cases T. Following "T" lines will contain a single integer A.
//
// Output:
// Output the count of different possible choices
//
// Constraints:
//
// 1 <= T < 100
// 1 <= A <= 10^5
//
// Example:
//
// Input :
// 3
// 6
// 4
// 7
//
// Output :
// 2
// 2
// 1

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.*;

public class P0649_TotalRectangles {
    public static void main(final String[] args) {
        final Set<Integer> primes = getPrimesUpTo(400);

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printTotalRectangles(in.nextInt(), primes);
        }
    }

    private static void printTotalRectangles(final int area, final Set<Integer> primes) {
        List<AbstractMap.SimpleEntry<Integer, Integer>> primeFactors = new ArrayList<>();

        int remainingArea = area;
        for (final int prime : primes) {
            if (remainingArea % prime == 0) {
                int factors = 1;
                for (remainingArea /= prime; remainingArea % prime == 0; remainingArea /= prime) {
                    factors += 1;
                }
                primeFactors.add(new AbstractMap.SimpleEntry<Integer, Integer>(prime, factors));
            }

            if (remainingArea > 1 && prime * prime > remainingArea) {
                primeFactors.add(new AbstractMap.SimpleEntry<Integer, Integer>(remainingArea, 1));
                remainingArea = 1;
            }

            if (remainingArea <= 1) {
                break;
            }
        }

        int totalRectangles = 1;
        boolean isEven = false;
        for (AbstractMap.SimpleEntry<Integer, Integer> primeFactor : primeFactors) {
            if (primeFactor.getKey() == 2) {
                isEven = true;
                totalRectangles *= 2;
            } else {
                totalRectangles *= primeFactor.getValue() + 1;
            }
        }

        int halfRectangles = (totalRectangles + 1) / 2;
        // totalRectangles will be odd if area is a square number.
        if (isEven && totalRectangles % 2 != 0) {
            halfRectangles += 1;
        }

        System.out.println(halfRectangles);
    }

    // Computes and returns set of all prime numbers up to input limit using Sieve of Eratosthenes.
    private static Set<Integer> getPrimesUpTo(final int limit) {
        final Set<Integer> primes = new TreeSet<>();

        final boolean[] isNotPrime = new boolean[limit + 1];
        for (int i = 2; i * i <= limit; i++) {
            if (!isNotPrime[i]) {
                for (int j = 2 * i; j <= limit; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int i = 2; i <= limit; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}
