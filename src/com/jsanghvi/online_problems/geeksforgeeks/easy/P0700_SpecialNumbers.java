// Problem ID: 700. Special numbers.
//
// Given the number of digits and a base, give the count of all the special numbers present in the range from zero to
// maximum for that combination of number of digits and base. Special number is defined as a number whose sum of digits
// in left half is equal to the sum of digits in its right half. For example, for base 10 and number of digits 4, total
// possible numbers will be 0000 to 9999, and in this range, 0642 is one special number as 0 + 6 = 4 + 2.
//
// Assumption:There are no test cases with odd number of digits.
//
// Input:
// First line contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists
// of two lines. First line of each test case contains an integer N, denoting the number of digits in the number. Second
// line of each test case contains an integer B, denoting the base.
//
// Output:
// For each test case print in a new line the count of all special numbers.
//
// Constraints:
// 1 <= T <= 70
// 1 <= N <= 6
// 1 <= B <= 10
//
// Example:
//
// Input:
// 2
// 4
// 2
// 2
// 10
//
// Output:
// 6
// 10

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0700_SpecialNumbers {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printSpecialNumbers(in.nextInt(), in.nextInt());
        }
    }

    private static void printSpecialNumbers(final int digits, final int base) {
        final int[] numberCountWithSum = new int[(digits / 2) * (base - 1) + 1];
        fillNumbersWithSum(numberCountWithSum, 0, digits / 2, base);

        int specialNumberCount = 0;
        for (final int numberCount : numberCountWithSum) {
            specialNumberCount += numberCount * numberCount;
        }
        System.out.println(specialNumberCount);
    }

    private static void fillNumbersWithSum(final int[] numbersWithSum, final int previousDigitSum,
                                           final int remainingDigits, final int base) {
        if (remainingDigits == 0) {
            numbersWithSum[previousDigitSum] += 1;
            return;
        }

        for (int currentDigitValue = 0; currentDigitValue < base; currentDigitValue++) {
            fillNumbersWithSum(numbersWithSum, previousDigitSum + currentDigitValue, remainingDigits - 1, base);
        }
    }
}
