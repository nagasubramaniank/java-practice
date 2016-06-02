// Problem ID: 762. Square number.
//
// A number k is called a square number if for some value of d > 1,  k % (d*d) = 0.
// Given a number N, the task is to find the total number of positive square numbers less than or equal to N.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test
// case consists of a single line containing a single integer N.
//
// Output:
// Corresponding to each test case, print in a new line an integer denoting the total number of positive square numbers
// less than or equal to N.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 10^9
//
// Example:
// Input:
// 3
// 2
// 4
// 10
//
// Output:
// 0
// 1
// 3
//
// Explanation:
//
// 4 -> (divisible by 2*2)
// 8 -> (divisible by 2*2)
// 9 -> (divisible by 3*3)
//
// For 2 -> no numbers less than or equal 2 are square numbers
// For 4 -> only 4 is a square number
// For 10 -> 4, 8, 9 are square numbers

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P0762_SquareNumber {
    public static void main(final String[] args) {
        final Map<Integer, Integer> squareFreeNumbers = getSquareFreeNumbers(32000);

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printSquareNumberCount(in.nextInt(), squareFreeNumbers);
        }
    }

    private static void printSquareNumberCount(final int number, final Map<Integer, Integer> squareFreeNumbers) {
        int count = 0;
        for (final Map.Entry<Integer, Integer> squareFreeNumber : squareFreeNumbers.entrySet()) {
            final int square = squareFreeNumber.getKey() * squareFreeNumber.getKey();
            if (square > number) {
                break;
            }
            count += (squareFreeNumber.getValue() % 2 == 1 ? 1 : -1) * (number / square);
        }

        System.out.println(count);
    }

    // Computes and returns numbers that have distinct prime factors. The key of every element in returned map contains
    // the square-free number, while value contains the count of prime factors.
    private static Map<Integer, Integer> getSquareFreeNumbers(final int limit) {

        final boolean[] isNotPrime = new boolean[limit + 1];
        for (int number = 2; number * number <= limit; number++) {
            if (!isNotPrime[number]) {
                for (int j = 2 * number; j <= limit; j += number) {
                    isNotPrime[j] = true;
                }
            }
        }

        final Map<Integer, Integer> squareFreeNumbers = new TreeMap<>();
        for (int number = 2; number <= limit; number++) {
            if (!isNotPrime[number]) {
                final Map<Integer, Integer> newSquareFreeNumbers = new HashMap<>();
                newSquareFreeNumbers.put(number, 1);

                for (final Map.Entry<Integer, Integer> squareFreeNumber : squareFreeNumbers.entrySet()) {
                    if (number * squareFreeNumber.getKey() > limit) {
                        break;
                    }

                    newSquareFreeNumbers.put(number * squareFreeNumber.getKey(), squareFreeNumber.getValue() + 1);
                }
                squareFreeNumbers.putAll(newSquareFreeNumbers);
            }
        }

        return squareFreeNumbers;
    }
}
