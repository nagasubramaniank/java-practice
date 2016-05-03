// Problem ID: 162. Egg Dropping Puzzle.
//
// The following is a description of the instance of this famous puzzle involving n=2 eggs and a building with k=36
// floors. Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which will
// cause the eggs to break on landing. We make a few assumptions:
//
// 1. An egg that survives a fall can be used again.
// 2. A broken egg must be discarded.
// 3. The effect of a fall is the same for all eggs.
// 4. If an egg breaks when dropped, then it would break if dropped from a higher floor.
// 5. If an egg survives a fall then it would survive a shorter fall.
// 6. It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause
//    an egg to break.
//
// In this problem you have to find minimum trials to solve for n eggs and k floors.
//
// Input:
// The first line contains an integer T, depicting total number of test cases.
// Then following T lines contains 2 integers n and k.
//
// Output:
// Print the minimum trials required to solve the problem.
//
// Constraints:
// 1 <= T <= 30
// 1 <= n <= 10
// 1 <= k <= 50
//
// Example:
// Input:
// 1
// 2 10
//
// Output:
// 4

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0162_EggDroppingPuzzle {
    public static void main(final String[] args) {
        final int[][] maximumFloors = getMaximumFloors(10, 50);

        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printMinimumTrials(in.nextInt(), in.nextInt(), maximumFloors);
        }
    }

    // Construct a table containing the maximum number of floors for which the problem can be solved, given the
    // remaining number of eggs and trials.
    private static int[][] getMaximumFloors(final int eggLimit, final int floorLimit) {
        final int[][] maximumFloors = new int[eggLimit + 1][floorLimit + 1];

        // maximumFloors[eggs][trials] will be zero if either eggs or trials are zero.

        for (int eggs = 1; eggs <= eggLimit; eggs++) {
            for (int trials = 1; trials <= floorLimit; trials++) {
                maximumFloors[eggs][trials] = maximumFloors[eggs - 1][trials - 1] + maximumFloors[eggs][trials - 1] + 1;

                // There is no need to compute maximum floors beyond the 'floorLimit'.
                if (maximumFloors[eggs][trials] > floorLimit) {
                    break;
                }
            }
        }

        return maximumFloors;
    }

    private static void printMinimumTrials(final int eggs, final int floors, final int[][] maximumFloors) {
        int trials;
        for (trials = 0; maximumFloors[eggs][trials] < floors; trials++) ;
        System.out.println(trials);
    }
}
