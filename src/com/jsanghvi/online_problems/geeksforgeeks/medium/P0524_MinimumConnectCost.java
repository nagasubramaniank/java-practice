// Problem ID: 524. Minimum Cost of ropes.
//
// There are given n ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two
// ropes is equal to sum of their lengths. We need to connect the ropes with minimum cost.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases. The first line of each test case is
// N. N is the number of ropes. The second line of each test case contains N inputs L[i], length of ropes.
//
// Output:
//
// Print the minimum cost.
//
// Constraints:
//
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 500
// 1 ≤ L[i] ≤ 500
//
// Example:
//
// Input:
// 1
// 4
// 4 3 2 6
//
// Output:
// 29
//
// Explanation:
//
// For example if we are given 4 ropes of lengths 4, 3, 2 and 6. We can connect the ropes in following ways.
// 1. First connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6 and 5.
// 2. Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
// 3. Finally connect the two ropes and all ropes have connected.
//
// Total cost for connecting all ropes is 5 + 9 + 15 = 29. This is the optimized cost for connecting ropes. Other ways
// of connecting ropes would always have same or more cost. For example, if we connect 4 and 6 first (we get three
// strings of 3, 2 and 10), then connect 10 and 3 (we get two strings of 13 and 2). Finally we connect 13 and 2. Total
// cost in this way is 10 + 13 + 15 = 38.

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class P0524_MinimumConnectCost {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] L = new int[N];

            for (int i = 0; i < N; i++) {
                L[i] = in.nextInt();
            }

            printMinimumConnectCost(L);
        }
    }

    private static void printMinimumConnectCost(final int[] ropes) {
        int minimumCost = 0;
        Queue<Integer> currentRopes = new PriorityQueue<>();

        for (int rope : ropes) {
            currentRopes.add(rope);
        }

        while (currentRopes.size() > 1) {
            int newRope = currentRopes.poll() + currentRopes.poll();
            minimumCost += newRope;
            currentRopes.add(newRope);
        }

        System.out.println(minimumCost);
    }
}
