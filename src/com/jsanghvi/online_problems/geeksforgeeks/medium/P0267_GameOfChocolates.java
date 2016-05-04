// Problem ID: 267. Game Of Chocolates.
//
// Bunty and Dolly are playing a game, described as follows.
//
// There are two boxes full of chocolates. Both can eat 'L' (L>=1) chocolates from any one box or 'L' chocolates from
// both the box in each step. They play the game alternatively and the last one to eat the chocolate will be the winner.
// As Bunty wants to impress Dolly, he wants to make Dolly the winner. You have to help Bunty in deciding who should
// play first. Assume that both the players play the game optimally.
//
// Input:
//
// The first line contains 'T' denoting the number of test cases. Then follows description of test cases. The next T
// lines contains the two space separated integers a and b denoting the number of chocolates in two boxes respectively.
//
// Output:
//
// For each test case , Output "Bunty" if Bunty should play first else print "Dolly".
//
// Constraints:
//
// 1 <= T <= 100
// 0 <= a <= 10^6
// 0 <= b <= 10^6
//
// Example:
//
// Input:
// 3
// 1 2
// 1 3
// 2 0
//
// Output :
// Bunty
// Dolly
// Dolly
//
// Explanation:
// In the first test case, if Bunty starts first, all the next possible state (0,2), (1,1), (0,1) are wining state for
// Dolly.

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0267_GameOfChocolates {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printWhoPlayFirst(in.nextInt(), in.nextInt());
        }
    }

    // As per https://en.wikipedia.org/wiki/Wythoff%27s_game, the strategy of the game revolves around cold positions
    // and hot positions. In a cold position, the player whose turn it is to move will lose with best play, while in a
    // hot position, the player whose turn it is to move will win with best play.
    //
    // 1. (0,0) is a cold position.
    // 2. Any position from which a cold position can be reached in a single move is a hot position.
    // 3. If every move leads to a hot position, then a position is cold.

    // Since it would take a table of size 1 GB to know whether a position, say 9 x 10^5, 10^6 is a cold position, it
    // would be easier to find the solution using 'Formula for cold positions'.

    private static void printWhoPlayFirst(final int chocolates1, final int chocolates2) {
        final int smallerBox = Math.min(chocolates1, chocolates2);
        final int largerBox = Math.max(chocolates1, chocolates2);
        final double golderRatio = (1.0 + Math.sqrt(5)) / 2.0;

        System.out.println(smallerBox == Math.floor((largerBox - smallerBox) * golderRatio) ? "Bunty" : "Dolly");
    }
}
