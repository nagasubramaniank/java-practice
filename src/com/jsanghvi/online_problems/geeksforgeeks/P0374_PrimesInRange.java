// Generate all prime numbers between two given numbers.
//
// Input:
//
// The first line contains t, the number of test cases (less then or equal to 70). Followed by t lines which contain two
// numbers m and n (1 <= m <= n <= 1000000000, n-m <= 100000) separated by a space.
//
// Output:
//
// For every test case print all prime numbers p such that m <= p <= n, space separated. Separate the answers for each
// test case by an empty line.
//
// Example:
//
// Input:
//
// 2
// 1 10
// 3 5
//
// Output:
//
// 2 3 5 7
// 3 5

package com.jsanghvi.online_problems.geeksforgeeks;

import java.util.Scanner;
import java.util.TreeSet;

public class P0374_PrimesInRange {
    public static void main(final String[] args) {
        TreeSet<Integer> primes = getPrimesUpTo((int) Math.sqrt(1000000000) + 1);

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {

            // For some reason, geeksforgeeks evaluator fails with NoSuchElementException inside nextInt() function,
            // hence it was required to add hasNextInt() checks.

            if (!in.hasNextInt()) {
                break;
            }

            final int low = in.nextInt();

            if (!in.hasNextInt()) {
                break;
            }

            final int high = in.nextInt();

            printPrimesInRange(low, high, primes);
        }
    }

    private static void printPrimesInRange(final int low, final int high, final TreeSet<Integer> primes) {
        final boolean[] isNotPrime = new boolean[high - low + 1];

        for (final int prime : primes) {
            if (prime * prime > high) {
                break;
            }

            for (int multiplier = Math.max(2, ((low - 1) / prime) + 1); multiplier * prime <= high; multiplier++) {
                isNotPrime[multiplier * prime - low] = true;
            }
        }

        for (int number = Math.max(2, low); number <= high; number++) {
            if (!isNotPrime[number - low]) {
                System.out.print(number + " ");
            }
        }

        System.out.println();
    }

    // Computes and returns set of all prime numbers up to input limit using Sieve of Eratosthenes.
    private static TreeSet<Integer> getPrimesUpTo(final int limit) {
        final TreeSet<Integer> primes = new TreeSet<>();

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
