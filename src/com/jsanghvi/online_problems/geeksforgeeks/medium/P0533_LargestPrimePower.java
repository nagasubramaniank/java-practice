// Problem ID: 533. Power of Largest Prime.
//
// You are given a number 'n'. Your task is to check whether the power of its largest prime factor is greater than one
// or not. Print "YES" if the power is greater than one otherwise print "NO".
//
// Input:
// First line contain 'T', number of test cases. T lines follow. Each line contains the number n.
//
// Output:
// Print the required answer for each test case in a separate line.
//
// Constraints:
// 1 <= T <= 30
// 1 <= n <= 10^18
//
// Example:
//
// Input:
// 3
// 36
// 100
// 13
//
// Output:
// YES
// YES
// NO
//
// Explanation
//
// 36 = 2*2*3*3
// largest prime factor is 3. Its power is greater than 1.

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class P0533_LargestPrimePower {
    public static void main(final String[] args) {
        final NavigableSet<Integer> primes = getPrimesUpTo(1000000);

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printLargestPrimePower(in.nextLong(), primes);
        }
    }

    private static void printLargestPrimePower(long number, final NavigableSet<Integer> primes) {
        int largestPrimePower = 0;

        for (final int prime : primes) {
            if (number == 1) {
                break;
            } else if (number % prime == 0) {
                for (largestPrimePower = 0; number % prime == 0; number /= prime, largestPrimePower++)
                    ;
            }
        }

        // We only took care of prime factors up to 10^6. If number is still greater than 1, it would have factors
        // greater than 10^6. Since the maximum value of number can be 10^18, it is impossible that it will have more
        // than two such factors (else value would go beyond 10^18). Now there are three possibilities, the remaining
        // number is a prime (one factor), it is multiple of two different prime factors, or it is multiple of two
        // same prime factors. We are only interested in the last case, so check for a squared number will suffice.

        if (number > 1) {
            double root = Math.sqrt(number);
            if (Math.abs(root - Math.round(root)) < 1e-6) {
                largestPrimePower = 2; // Square of prime number.
            } else {
                largestPrimePower = 1; // Prime number or multiple of two different prime numbers.
            }
        }

        System.out.println(largestPrimePower > 1 ? "YES" : "NO");
    }

    // Computes and returns set of all prime numbers up to input limit using Sieve of Eratosthenes.
    private static NavigableSet<Integer> getPrimesUpTo(final int limit) {
        final NavigableSet<Integer> primes = new TreeSet<>();

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
