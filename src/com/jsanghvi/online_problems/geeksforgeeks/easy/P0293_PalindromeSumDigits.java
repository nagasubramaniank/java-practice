// Problem ID: 293. Sum of Digit is palindrome or not.
//
// Write a program to check if the sum of digits of a given number is palindrome number or not.
//
// Input:
// The first line of the input contains T denoting the number of test cases.Then each of the T lines contains single
// positive integer N denoting the value of number.
//
// Output:
// Output "YES" if palindrome else "NO". (without the quotes)
// ​
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 1000
//
// Example:
//
// Input:
// 2
// 56
// 98
//
// Output:
// YES
// NO

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0293_PalindromeSumDigits {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printIsPalindromeSumDigits(in.nextInt());
        }
    }

    private static void printIsPalindromeSumDigits(final int number) {
        int sumDigit = 0;
        for (int remainingNumber = number; remainingNumber > 0; remainingNumber /= 10) {
            sumDigit += (remainingNumber % 10);
        }

        System.out.println((sumDigit < 10 || sumDigit / 10 == sumDigit % 10) ? "YES" : "NO");
    }
}
