// Problem ID: 692. Cycle race.
//
// In CycleLand Jack and Jelly are two friends. They want to go CycleSchool by a cycle (Assume that they live in same
// house). Distance between CycleSchool and their house is 'N' km. Jack and Jelly both like their classmate Jenny. They
// decided to play a game such that the winner will get a chance to sit with Jenny in school. Rules of game are as
// follows:
//
// - Initially Jelly will ride cycle.
// - They will ride cycle one by one.
// - When one is riding cycle other will sit on the carrier of cycle.
// - In each ride they can ride cycle exactly 1, 2 or 4 km. One cannot ride more than remaining distance.
// - One who reaches school riding cycle will get a chance to sit with Jenny.
//
// Both play optimally. You have to find who will win this game.
//
// Input:
// First line of input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. Each test
// case consists of a single line containing an integer N.
//
// Output:
// Print the name of winner i.e 'JACK' or 'JELLY'.
//
// Constraints:
// 1 <= T <= 100
// 1 <= N <= 10000000
//
// Example:
// Input
// 3
// 2
// 3
// 5
//
// Output:
// JELLY
// JACK
// JELLY

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0692_CycleRaceWinner {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printCycleRaceWinner(in.nextInt());
        }
    }

    private static void printCycleRaceWinner(final int distance) {

        // For distance 1, 2, and 4, Jelly would win the game. However for distance 3, Jack will win the game.
        // For a given distance, the player riding cycle will make the remaining distance to be multiple of 3, after
        // which the next player will never get a chance to win the game. Since Jelly is the first one to ride the
        // cycle, he will win if distance is not multiple of 3, otherwise Jack will win.

        System.out.println(distance % 3 == 0 ? "JACK" : "JELLY");
    }
}
