// Problem 1. Eight Queens Puzzle
//
// Place eight chess queens on an 8×8 chessboard so that no two queens threaten each other.

package com.jsanghvi.algorithms.backtracking;

public class EightQueensPuzzle {
    public static void main(String[] args) {
        printEightQueensSolutions();
    }

    private static void printEightQueensSolutions() {
        int[] columnPositionAtRow = new int[8];
        boolean[] filledColumns = new boolean[8];
        boolean[] filledFrontDiagonals = new boolean[15];
        boolean[] filledBackDiagonals = new boolean[15];

        int numSolutions = printEightQueensSolutions(0, columnPositionAtRow, filledColumns, filledFrontDiagonals,
                filledBackDiagonals);

        System.out.println("Total Number of Eight Queens Puzzle Solutions: " + numSolutions);
    }

    private static int printEightQueensSolutions(final int row, final int[] columnPositionAtRow,
                                                 final boolean[] filledColumns, final boolean[] filledFrontDiagonals,
                                                 final boolean[] filledBackDiagonals) {

        if (row == 8) {
            printChessBoard(columnPositionAtRow);
            return 1;
        }

        int numSolutions = 0;

        for (int column = 0; column < 8; column++) {
            if (isValidPosition(row, column, filledColumns, filledFrontDiagonals, filledBackDiagonals)) {
                fillPosition(row, column, filledColumns, filledFrontDiagonals, filledBackDiagonals);
                columnPositionAtRow[row] = column;
                numSolutions += printEightQueensSolutions(row + 1, columnPositionAtRow, filledColumns,
                        filledFrontDiagonals, filledBackDiagonals);
                emptyPosition(row, column, filledColumns, filledFrontDiagonals, filledBackDiagonals);
            }
        }

        return numSolutions;
    }

    private static boolean isValidPosition(int row, int column, boolean[] filledColumns, boolean[] filledFrontDiagonals,
                                           boolean[] filledBackDiagonals) {
        return !filledColumns[column] && !filledFrontDiagonals[row + column] && !filledBackDiagonals[row - column + 7];
    }

    private static void fillPosition(int row, int column, boolean[] filledColumns, boolean[] filledFrontDiagonals,
                                     boolean[] filledBackDiagonals) {
        filledColumns[column] = filledFrontDiagonals[row + column] = filledBackDiagonals[row - column + 7] = true;
    }

    private static void emptyPosition(int row, int column, boolean[] filledColumns, boolean[] filledFrontDiagonals,
                                      boolean[] filledBackDiagonals) {
        filledColumns[column] = filledFrontDiagonals[row + column] = filledBackDiagonals[row - column + 7] = false;
    }

    private static void printChessBoard(final int[] columnPositionAtRow) {
        StringBuffer board = new StringBuffer();

        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                board.append(column == columnPositionAtRow[row] ? 'Q' : '.');
            }
            board.append('\n');
        }

        System.out.println(board);
    }
}
