// Problem ID: 668. Tic-Tac-Toe.
//
// A Tic-Tac-Toe board is given after some moves are played. Find out if the given board is valid, i.e., is it possible
// to reach this board position after some moves or not. The game start with X.
//
// Note that every arbitrary filled grid of 9 spaces isn’t valid e.g. a grid filled with 3 X and 6 O isn’t valid
// situation because each player needs to take alternate turns.
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is given as a 1D array of size 9.
//
// Output:
//
// Print Valid if board is valid, else Invalid.
//
// Constraints:
//
// 1 ≤ T ≤ 100
//
// Example:
//
// Input:
// 2
// X X O O X O O O O
// X X O O O X X O X
//
// Output:
// Invalid
// Valid

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0668_TicTacToe {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final char[][] board = new char[3][3];

            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    board[row][column] = in.next().charAt(0);
                }
            }

            printIsValidPosition(board);
        }
    }

    private static void printIsValidPosition(final char[][] board) {
        BoardPosition[] oPositions = new BoardPosition[9];
        int numberOfOs = 0;

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (board[row][column] == 'O') {
                    // Put Os on slanted board such that no two cells in the board are horizontally or vertically
                    // aligned. This prevent divide by zero error.
                    oPositions[numberOfOs++] = new BoardPosition(row * 3 + column, column * 3 + row);
                }
            }
        }

        // Total number of Os on board should be exactly 4.
        if (numberOfOs != 4) {
            System.out.println("Invalid");
            return;
        }

        // Second person cannot win else we would not have all cells filled.
        if ((slope(oPositions[0], oPositions[1]) == slope(oPositions[0], oPositions[2]))
                || (slope(oPositions[0], oPositions[1]) == slope(oPositions[0], oPositions[3]))
                || (slope(oPositions[0], oPositions[2]) == slope(oPositions[0], oPositions[3]))
                || (slope(oPositions[1], oPositions[2]) == slope(oPositions[1], oPositions[3]))) {
            System.out.println("Invalid");
            return;
        }

        System.out.println("Valid");
    }

    private static double slope(final BoardPosition position1, final BoardPosition position2) {
        return Math.round((position1.row - position2.row) / (position1.column - position2.column) * 100d) / 100d;
    }

    private static class BoardPosition {
        final double row, column;

        private BoardPosition(final double row, final double column) {
            this.row = row;
            this.column = column;
        }
    }
}
