// Problem 1. Knight Stay Probability
//
// Give a chessboard of size N x N and knight's position, what is the probability that it will stay on the board after
// K moves.

package com.jsanghvi.algorithms.hashing;

import java.util.HashMap;
import java.util.Map;

class KnightStayProbability {
    private final Map<KnightStatus, Double> stayProbabilities = new HashMap<>();
    private final int boardSize;

    private KnightStayProbability(final int boardSize) {
        this.boardSize = boardSize;
    }

    public static void main(String[] args) {

        KnightStayProbability knightStayProbability = new KnightStayProbability(1);
        knightStayProbability.printStayProbability(0, 0, 0);
        knightStayProbability.printStayProbability(1, 0, 0);

        knightStayProbability = new KnightStayProbability(8);
        for (int moves = 0; moves < 16; moves++) {
            knightStayProbability.printStayProbability(moves, 1, 3);
        }
    }

    private void printStayProbability(final int moves, final int row, final int column) {
        if (row < 0 || row >= this.boardSize || column < 0 || column >= this.boardSize) {
            throw new IllegalArgumentException("Invalid Knight Position");
        }

        System.out.println("Knight Stay Probability (board size: " + boardSize + ", moves: " + moves
                + ", row position: " + row + ", column position: " + column + "): "
                + stayProbability(new KnightStatus(row, column, moves)));
    }

    private double stayProbability(final KnightStatus knightStatus) {
        if (knightStatus.row < 0 || knightStatus.row >= this.boardSize || knightStatus.column < 0
                || knightStatus.column >= this.boardSize) {
            return 0.0;
        }

        if (knightStatus.remainingMoves <= 0) {
            return 1.0;
        }

        if (!this.stayProbabilities.containsKey(knightStatus)) {
            double stayProbability = (
                    stayProbability(knightStatus.getNextStatus(KnightMove.UP_THEN_LEFT))
                            + stayProbability(knightStatus.getNextStatus(KnightMove.UP_THEN_RIGHT))
                            + stayProbability(knightStatus.getNextStatus(KnightMove.LEFT_THEN_UP))
                            + stayProbability(knightStatus.getNextStatus(KnightMove.LEFT_THEN_DOWN))
                            + stayProbability(knightStatus.getNextStatus(KnightMove.RIGHT_THEN_UP))
                            + stayProbability(knightStatus.getNextStatus(KnightMove.RIGHT_THEN_DOWN))
                            + stayProbability(knightStatus.getNextStatus(KnightMove.DOWN_THEN_LEFT))
                            + stayProbability(knightStatus.getNextStatus(KnightMove.DOWN_THEN_RIGHT))
            ) / 8.0;

            this.stayProbabilities.put(knightStatus, stayProbability);
        }

        return stayProbabilities.get(knightStatus);
    }

    private enum KnightMove {
        UP_THEN_LEFT, UP_THEN_RIGHT, LEFT_THEN_UP, LEFT_THEN_DOWN, RIGHT_THEN_UP, RIGHT_THEN_DOWN, DOWN_THEN_LEFT,
        DOWN_THEN_RIGHT
    }

    private class KnightStatus {
        private final int row, column;
        private final int remainingMoves;

        public KnightStatus(final int row, final int column, final int remainingMoves) {
            this.row = row;
            this.column = column;
            this.remainingMoves = remainingMoves;
        }

        public KnightStatus getNextStatus(KnightMove knightMove) {
            switch (knightMove) {
                case UP_THEN_LEFT:
                    return new KnightStatus(row - 2, column - 1, remainingMoves - 1);
                case UP_THEN_RIGHT:
                    return new KnightStatus(row - 2, column + 1, remainingMoves - 1);
                case LEFT_THEN_UP:
                    return new KnightStatus(row - 1, column - 2, remainingMoves - 1);
                case LEFT_THEN_DOWN:
                    return new KnightStatus(row + 1, column - 2, remainingMoves - 1);
                case RIGHT_THEN_UP:
                    return new KnightStatus(row - 1, column + 2, remainingMoves - 1);
                case RIGHT_THEN_DOWN:
                    return new KnightStatus(row + 1, column + 2, remainingMoves - 1);
                case DOWN_THEN_LEFT:
                    return new KnightStatus(row + 2, column - 1, remainingMoves - 1);
                case DOWN_THEN_RIGHT:
                    return new KnightStatus(row + 2, column + 1, remainingMoves - 1);
            }

            return null;
        }

        private KnightStatus normalize() {
            int row = Math.min(this.row, boardSize - 1 - this.row); // Vertical fold
            int column = Math.min(this.column, boardSize - 1 - this.column); // Horizontal fold
            return new KnightStatus(Math.max(row, column), Math.min(row, column), this.remainingMoves); // Diagonal fold
        }

        // Take advantage of symmetry of square board to avoid re-computation.

        @Override
        public boolean equals(final Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;

            final KnightStatus normalizedThat = ((KnightStatus) object).normalize();
            final KnightStatus normalizedThis = this.normalize();

            return normalizedThis.row == normalizedThat.row && normalizedThis.column == normalizedThat.column
                    && normalizedThis.remainingMoves == normalizedThat.remainingMoves;
        }

        @Override
        public int hashCode() {
            final KnightStatus normalizedThis = this.normalize();

            int result = normalizedThis.row;
            result = 31 * result + normalizedThis.column;
            result = 31 * result + normalizedThis.remainingMoves;
            return result;
        }
    }
}
