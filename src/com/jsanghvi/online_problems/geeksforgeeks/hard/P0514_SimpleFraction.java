// Problem ID: 514. Simple Fraction.
//
// Given a fraction. Convert it into a decimal. So simple :P
//
// e.g. 10/2 = 5, 3/5 = 0.6
//
// (The Question Begins Now)  :D
// If the decimals are repeating recursively, then enclose them inside ().
//
// e.g. 8/3 = 2.(6) as 8/3 = 2.66666666.......  infinitly.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is an integer N denoting the numerator of fraction.
// The second line of each test case is an integer D denoting the denominator of fraction.
//
// Output:
//
// Print decimal of that fraction in separate line for each test case.
//
// Constraints:
//
// 1 ≤ T ≤ 100
// 1 ≤ N,D ≤ 2000
//
// Example:
//
// Input
// 2
// 4
// 2
// 8
// 3
//
// Output
// 2
// 2.(6)

package com.jsanghvi.online_problems.geeksforgeeks.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P0514_SimpleFraction {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int D = in.nextInt();
            printDecimal(N, D);
        }
    }

    private static void printDecimal(final int numerator, final int denominator) {

        if (numerator % denominator == 0) {
            System.out.println(numerator / denominator);
            return;
        }

        final Map<Integer, Integer> dividendPlace = new HashMap<>();
        final StringBuilder decimals = new StringBuilder();

        int dividend, place;
        for (dividend = numerator % denominator, place = 0; !dividendPlace.containsKey(dividend);
             dividend = (dividend * 10) % denominator, place++) {

            dividendPlace.put(dividend, place);
            decimals.append((dividend * 10) / denominator);
        }

        if (dividend == 0) {
            decimals.setLength(decimals.length() - 1);
        } else {
            decimals.insert(dividendPlace.get(dividend).intValue(), '(');
            decimals.append(')');
        }

        System.out.println((numerator / denominator) + "." + decimals.toString());
    }
}
