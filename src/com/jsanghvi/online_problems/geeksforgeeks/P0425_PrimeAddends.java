// Problem ID: 425. Return two prime numbers.
//
// Given an even number (greater than 2), return two prime numbers whose sum will be equal to given number. There are
// several combinations possible. Print only first such pair.
//
// NOTE: A solution will always exist, read Goldbach’s conjecture.
//
// Also, solve the problem in linear time complexity, i.e., O(n).
//
// Input:
//
// The first line contains T, the number of test cases. The following T lines consist of a number each, for which we'll
// find two prime numbers.
//
// Note: The number would always be an even number.
//
// Output:
//
// For every test case print two prime numbers space separated, such that the smaller number appears first. Answer for
// each test case must be in a new line.
//
// Constraints:
//
// 1 ≤ T ≤ 70
// 1 ≤ N ≤ 10000
//
// Example:
//
// Input:
//
// 5
// 74
// 1024
// 66
// 8
// 9990
//
// Output:
//
// 3 71
// 3 1021
// 5 61
// 3 5
// 17 9973

package com.jsanghvi.online_problems.geeksforgeeks;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P0425_PrimeAddends {
    public static void main(final String[] args) {
        Set<Integer> primes = getPrimesUpTo(10000);

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            printPrimeAddends(in.nextInt(), primes);
        }
    }

    private static void printPrimeAddends(final int sum, Set<Integer> primes) {
        for (int prime : primes) {
            if (primes.contains(sum - prime)) {
                System.out.println(prime + " " + (sum - prime));
                return;
            }
        }
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
