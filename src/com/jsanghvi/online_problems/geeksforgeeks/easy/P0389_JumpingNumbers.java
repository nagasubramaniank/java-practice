// Problem ID: 389. Jumping Numbers.
//
// Given a positive number x, print all Jumping Numbers smaller than or equal to x. A number is called as a Jumping
// Number if all adjacent digits in it differ by 1. The difference between ‘9’ and ‘0’ is not considered as 1. All
// single digit numbers are considered as Jumping Numbers. For example 7, 8987 and 4343456 are Jumping numbers but 796
// and 89098 are not.
//
// Input:
// The first line of the input contains T denoting the number of test cases. Each test case contain a positive number
// 'x'.
//
// Output:
// All the jumping numbers less than 'x' are generated in increasing order of the most significant digit. See example
// for better understanding.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 100000
//
// Example:
//
// Input:
// 2
// 10
// 50
//
// Output:
// 0 1 10 2 3 4 5 6 7 8 9
// 0 1 10 12 2 21 23 3 32 34 4 43 45 5 6 7 8 9
//
// Here, the most significant digits of each jumping number is following increasing order, i.e. jumping numbers starting
// from 0, followed by 1, then 2 and so on, themselves being in increasing order 2, 21, 23.

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P0389_JumpingNumbers {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printJumpingNumbers(in.nextInt());
        }
    }

    private static void printJumpingNumbers(final int upTo) {
        StringBuilder output = new StringBuilder();
        output.append(0).append(' ');

        Queue<Integer> jumpingNumbers = new LinkedList<>();
        for (int firstDigit = 1; firstDigit <= 9; firstDigit++) {
            jumpingNumbers.add(firstDigit);
            printJumpingNumbers(jumpingNumbers, upTo, output);
        }
        System.out.println(output);
    }

    private static void printJumpingNumbers(final Queue<Integer> jumpingNumbers, final int upTo,
                                            final StringBuilder output) {

        while (!jumpingNumbers.isEmpty()) {
            final int jumpingNumber = jumpingNumbers.poll();
            if (jumpingNumber > upTo) {
                continue;
            }

            output.append(jumpingNumber).append(' ');

            if (jumpingNumber % 10 != 0) {
                jumpingNumbers.add(jumpingNumber * 10 + (jumpingNumber % 10 - 1));
            }

            if (jumpingNumber % 10 != 9) {
                jumpingNumbers.add(jumpingNumber * 10 + (jumpingNumber % 10 + 1));
            }
        }
    }
}
