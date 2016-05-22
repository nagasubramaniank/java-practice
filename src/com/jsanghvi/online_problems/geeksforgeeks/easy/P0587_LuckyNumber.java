// Problem ID: 587. Lucky number.
//
// A n digit number has n*(n+1)/2 sub-numbers.  For example, all possible sub-numbers of 975 are 9 7 5 97 75 975. A
// number is called Lucky if all sub-numbers have different digit product.  Digit product of a number is product of its
// digits.
//
// For example, the number 23 is Lucky.  Subsequences of it are 2, 3 and 23 and digit products are 2, 3 and 6
// respectively (All digit products are different). 975 is also lucky.
//
// Input:
// The first line contains an integer T, depicting total number of test cases.
// Then following T lines contains an integer N .
//
// Output:
// Print 1 if number is lucky else print 0.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 10^10
//
// Example:
//
// Input:
// 2
// 324
// 323
//
// Output:
// 1
// 0

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.*;

public class P0587_LuckyNumber {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printIsLuckyNumber(in.nextLong());
        }
    }

    private static void printIsLuckyNumber(final long number) {
        List<Integer> digits = new ArrayList<>(11);

        for (long remainingNumber = number; remainingNumber > 0; remainingNumber /= 10) {
            digits.add((int) (remainingNumber % 10));
        }

        Set<Integer> products = new HashSet<>();
        for (int start = 0; start < digits.size(); start++) {
            int product = 1;
            for (int end = start; end < digits.size(); end++) {
                product *= digits.get(end);

                if (products.contains(product)) {
                    System.out.println(0);
                    return;
                }

                products.add(product);
            }
        }

        System.out.println(1);
    }
}
