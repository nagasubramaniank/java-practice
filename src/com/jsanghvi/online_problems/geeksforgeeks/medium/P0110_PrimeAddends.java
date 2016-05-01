// Problem ID: 110. Sum Of Prime.
//
// Given a number (greater than 2), print two prime numbers whose sum will be equal to given number, else print -1 if no
// such number exists.
//
// NOTE: A solution will always exist if the number is even. Read Goldbach’s conjecture.
//
// If [a, b] is one solution with a <= b, and [c, d] is another solution with c <= d, and a < c then print [a, b] only
// and not all possible solutions.
//
// Input:
//
// The first line contains an integer T, depicting total number of test cases. Then following T lines contains an
// integer N.
//
// Output:
//
// Print the two prime numbers in a single line with space in between.
//
// Constraints:
//
// 1 ≤ T ≤ 50
// 1 ≤ N ≤ 1000000
//
// Example:
//
// Input
// 2
// 8
// 3
//
// Output
// 3 5
// -1

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P0110_PrimeAddends {
    public static void main(final String[] args) {
        Set<Integer> primes = getPrimesUpTo(1000000);

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            printPrimeAddends(in.nextInt(), primes);
        }
    }

    private static void printPrimeAddends(final int sum, Set<Integer> primes) {
        for (int prime : primes) {

            if (prime > sum / 2) {
                break;
            }

            if (primes.contains(sum - prime)) {
                System.out.println(prime + " " + (sum - prime));
                return;
            }
        }

        System.out.println(-1);
    }

    // Computes and returns set of all prime numbers up to the limit using Sieve of Eratosthenes.
    private static Set<Integer> getPrimesUpTo(final int limit) {

        Set<Integer> primes = new TreeSet<>();
        boolean[] isNotPrime = new boolean[limit + 1];

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
