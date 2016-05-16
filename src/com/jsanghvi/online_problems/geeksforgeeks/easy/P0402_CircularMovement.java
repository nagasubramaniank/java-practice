// Problem ID: 402. Does robot moves circular.
//
// Given a sequence of moves for a robot, check if the sequence is circular or not. A sequence of moves is circular if
// first and last positions of robot are same. A move can be on of the following.
//
// G - Go one unit
// L - Turn left
// R - Turn right
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is a String in capital letter, sequence of moves consisting only {R,G,L}.
//
// Output:
// Print Given sequence of moves is circular if first and last positions of robot are same. else Given sequence of moves
// is NOT circular.
//
// Constraints:
// 1 ≤ T ≤ 50
// 1 ≤ size of string ≤ 200
//
// Example:
//
// Input:
// 3
// GLGLGLG
// GLLG
// GGGGL
//
// Output:
// Circular
// Circular
// Not Circular

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0402_CircularMovement {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printIsCircularMovement(in.next());
        }
    }

    private static void printIsCircularMovement(final String movements) {
        final int[][] advances = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int currentAdvance = 0;
        int[] currentPosition = new int[]{0, 0};

        for (int i = 0; i < movements.length(); i++) {
            switch (movements.charAt(i)) {
                case 'L':
                    currentAdvance = (currentAdvance + 1) % 4;
                    break;
                case 'R':
                    currentAdvance = (currentAdvance + 3) % 4;
                    break;
                case 'G':
                    currentPosition[0] += advances[currentAdvance][0];
                    currentPosition[1] += advances[currentAdvance][1];
                    break;
            }
        }

        System.out.println(currentPosition[0] == 0 && currentPosition[1] == 0 ? "Circular" : "Not Circular");
    }
}
