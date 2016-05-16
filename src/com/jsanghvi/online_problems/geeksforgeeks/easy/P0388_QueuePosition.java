// Problem ID: 388. Finding Position.
//
// Some people are standing in a queue. A selection process follows a rule where people standing on even positions are
// selected. Of the selected people a queue is formed and again out of these only people on even position are selected.
// This continues until we are left with one person. Find out the position of that person in the original queue.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N,number of people standing in a queue.
//
// Output:
// Print the position(original queue) of that person who is left.
//
// Constraints:
// 1 ≤ T ≤ 1000
// 1 ≤ N ≤ 100000000
//
// Example:
//
// Input:
// 1
// 5
//
// Output:
// 4

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0388_QueuePosition {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printQueuePosition(in.nextInt());
        }
    }

    private static void printQueuePosition(final int queueLength) {
        System.out.println((int) Math.pow(2, Math.floor(Math.log(queueLength) / Math.log(2))));
    }
}
