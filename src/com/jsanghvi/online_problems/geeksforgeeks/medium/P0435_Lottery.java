// Problem ID: 435. Lottery.
//
// A lottery firm sold lottery tickets which contained a lottery number. The firm created a 3 stage process to win the
// lottery. In the first stage the condition for qualifying are:
//
// 1. The binary of the lottery number must contain 101010 in it.
// 2. The number of 1's in lottery number binary form excluding those 1 which are included in 101010 should be multiple
//    of 3.
//
// If both condition are met the person qualifies else he disqualifies. Write a program for the lottery firm to check
// whether the person has qualified the first stage or not.
//
// Input:
// First line contains no. of test cases T. Next T line contains a number in each line.
//
// Output:
// Print no. of 1’s that are in binary form of number excluding those in 101010 and ’Qualified’ if it satisfies the
// condition and ‘Disqualified’ if it does not as shown below.
//
// Constraints:
// 1 <=T<= 30
// 1 <= N <= 1000000
//
// Example:
//
// Input:
// 3
// 2901
// 2730
// 702568
//
// Output:
// 3 Qualified
// Disqualified
// 6 Qualified
//
// Explanation:
// Considering 2901:
// Binary conversion of 2901 is 101101010101
// Condition 1: It must contain 101010 as a substring is satisfied.
// Condition 2: There are two possible substrings which include 101010. They are 101101010101 and 101101010101.
// Now the 1's which does not include in 101010 are at 1st, 3rd and 12th position.Therefore, the number of 1's remaining are multiples of 3. Which makes the number 2901 qualified.

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0435_Lottery {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printQualification(in.nextInt());
        }
    }

    private static void printQualification(int lotteryNumber) {
        int numMatches = 0, numOnes = 0, lastMatchBitPosition = -10;
        for (int bitPosition = 0; lotteryNumber > 0; bitPosition++) {
            if ((lotteryNumber & 63) == 42) {
                numMatches += Math.min(3, (bitPosition - lastMatchBitPosition) / 2);
                lastMatchBitPosition = bitPosition;
            }

            if ((lotteryNumber & 1) == 1) {
                numOnes += 1;
            }

            lotteryNumber >>>= 1;
        }

        if (numMatches > 0 && numOnes - numMatches >= 3) {
            System.out.println((numOnes - numMatches) + " Qualified");
        } else {
            System.out.println("Disqualified");
        }
    }
}
