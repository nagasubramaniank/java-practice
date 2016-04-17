// Problem 7. Optimal Strategy for a Game
//
// Consider a row of n coins of values v(1) ... v(n), where n is even. We play a game against an opponent by alternating
// turns. In each turn, a player selects either the first or last coin from the row, removes it from the row
// permanently, and receives the value of the coin. Determine the maximum possible amount of money we can definitely
// win if we move first.

package com.jsanghvi.algorithms.dynamic_programming;

public class OptimalStrategyGame {
    public static void main(String[] args) {
        int[] coinValues = new int[]{0, 8, 4, 12, 2, 6, 10, 14, 1, 9, 5, 13, 3, 7, 11, 15};
        printOptimalSequence(coinValues);
    }

    private static void printOptimalSequence(final int[] coinValues) {
        int[][] optimalValueTable = new int[coinValues.length][coinValues.length];
        Removal[][] removals = new Removal[coinValues.length][coinValues.length];

        for (int length = 1; length <= coinValues.length; length++) {
            for (int left = 0; left <= coinValues.length - length; left++) {
                int right = left + length - 1;

                int optimalValueIfLeftRemoved = 0, optimalValueIfRightRemoved = 0;

                if (length <= 2) {
                    // If length of sequence is 1, optimal value is simply equal to that coin.
                    // If length of sequence is 2, optimal value is maximum of the two coins.
                    optimalValueIfLeftRemoved = coinValues[left];
                    optimalValueIfRightRemoved = coinValues[right];
                } else {
                    optimalValueIfLeftRemoved = coinValues[left]
                            + Math.min(optimalValueTable[left + 2][right], optimalValueTable[left + 1][right - 1]);
                    optimalValueIfRightRemoved = coinValues[right]
                            + Math.min(optimalValueTable[left + 1][right - 1], optimalValueTable[left][right - 2]);
                }

                if (optimalValueIfLeftRemoved >= optimalValueIfRightRemoved) {
                    optimalValueTable[left][right] = optimalValueIfLeftRemoved;
                    removals[left][right] = Removal.LEFT;
                } else {
                    optimalValueTable[left][right] = optimalValueIfRightRemoved;
                    removals[left][right] = Removal.RIGHT;
                }
            }
        }

        System.out.println("Optimal Value: " + optimalValueTable[0][coinValues.length - 1]);

        System.out.print("Input Sequence: ");
        for (int coinValue : coinValues) {
            System.out.print(coinValue + " ");
        }
        System.out.println();

        System.out.print("Removal Sequence: ");
        for (int left = 0, right = coinValues.length - 1; left <= right; ) {
            if (removals[left][right] == Removal.LEFT) {
                System.out.print(coinValues[left] + " ");
                left += 1;
            } else {
                System.out.print(coinValues[right] + " ");
                right -= 1;
            }
        }

        System.out.println();
        System.out.println();
    }

    private enum Removal {
        LEFT, RIGHT
    }
}
