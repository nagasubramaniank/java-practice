// Problem ID: 701. Where am I?
//
// You are given a set of movements of a person, find out his total displacement from origin and the direction in which
// he will be facing if initially he was facing North and standing at origin. The movements can be any one of the
// following four:
//
// Up: Representing forward movement, denoted by 'U', along with the distance in that direction.
//
// Down: Representing backward movement, denoted by 'D', along with the distance in that direction. The direction of his
// face will be in opposite of which he was facing to earlier.
//
// Left: Representing Left turn and then a forward movement, denoted by 'L', along with the distance in that direction.
// The direction of his face will turn to the left side to which he was facing to earlier, For e.g, if he was facing
// North, after this movement he will face West.
//
// Right: Representing a Right turn and then a forward movement, denoted by 'R', along with the distance in that
// direction. The direction of his face will turn to the right of which he was facing to earlier, For e.g, if he was
// facing North after this movement he will face East.
//
// Input:
// First line of the input contains an integer T denoting the number of test cases. Then T test cases follow. Each test
// case consists of two lines. First line of each test case contains an integer M denoting the number of movements.
// Second line of each test case contains M pairs, each pair consisting of a character C (C can be one of the following:
// 'U' for upward, 'D' for Down, 'L' for Left, 'R' for Right) and an integer D. The character represents the movement
// type and the integer represents the distance for that movement. See example input for better understanding.
//
// Output:
// For each test case print the final displacement of the person from origin and the final direction('N' for
// North, 'S' for South, 'E' for East, 'W' for West) to which he is facing. If the displacement is a fraction, output
// its floor( after truncating the fractional part) value.
//
// Constraints:
// 1 <= T <= 100
// 1 <= M <= 100
// C is an element of {'U','D','L','R'}
// 1 <= D <= 10
//
// Example:
//
// Input:
// 3
// 5
// U 1 R 1 R 1 R 1 R 0
// 5
// U 5 L 5 R 5 D 5 R 5
// 4
// U 1 U 1 U 2 D 1
//
// Output:
// 0 N
// 11 W
// 3 S

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0701_DisplacementDirection {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int M = in.nextInt();
            final char[] C = new char[M];
            final int[] D = new int[M];

            for (int i = 0; i < M; i++) {
                C[i] = in.next().charAt(0);
                D[i] = in.nextInt();
            }

            printDisplacementDirection(C, D);
        }
    }

    private static void printDisplacementDirection(final char[] turns, final int[] movements) {
        int direction = 0;
        int xPosition = 0, yPosition = 0;

        for (int i = 0; i < turns.length; i++) {
            switch (turns[i]) {
                case 'R':
                    direction = (direction + 1) % 4;
                    break;
                case 'D':
                    direction = (direction + 2) % 4;
                    break;
                case 'L':
                    direction = (direction + 3) % 4;
                    break;
            }

            switch (direction) {
                case 0:
                    yPosition += movements[i];
                    break;
                case 1:
                    xPosition += movements[i];
                    break;
                case 2:
                    yPosition -= movements[i];
                    break;
                case 3:
                    xPosition -= movements[i];
                    break;
            }
        }

        final char[] directionLetter = new char[]{'N', 'E', 'S', 'W'};

        System.out.println((int) (Math.sqrt(xPosition * xPosition + yPosition * yPosition)) + " "
                + directionLetter[direction]);
    }
}
