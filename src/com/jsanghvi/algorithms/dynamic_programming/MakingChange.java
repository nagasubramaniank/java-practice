// Problem 2. Making Change
//
// You are given n types of coin denominations of values v(1) < v(2) < ... < v(n) (all integers). Assume v(1) = 1, so
// you can always make change for any amount of money C. Give an algorithm which makes change for an amount of money C
// with as few coins as possible.

package com.jsanghvi.algorithms.dynamic_programming;

class MakingChange {
    public static void main(String[] args) {
        int[] denominations = new int[]{1, 2, 5, 10, 20, 25};
        printChangeUpto(100, denominations);
        System.out.println();

        denominations = new int[]{1, 3, 7, 15, 31, 63};
        printChangeUpto(100, denominations);
        System.out.println();
    }

    private static void printChangeUpto(final int maxValue, final int[] denominations) {
        final int[] minDenominations = new int[maxValue + 1];
        final int[] lastValues = new int[maxValue + 1];

        lastValues[0] = -1;
        minDenominations[0] = 0;

        for (int value = 1; value <= maxValue; value++) {
            lastValues[value] = 0;
            minDenominations[value] = Integer.MAX_VALUE;

            for (final int denomination : denominations) {
                final int lastValue = value - denomination;
                if (lastValue < 0) {
                    break;
                }

                if (minDenominations[value] > minDenominations[lastValue] + 1) {
                    minDenominations[value] = minDenominations[lastValue] + 1;
                    lastValues[value] = lastValue;
                }
            }

            System.out.print("Value: " + value + ", Denominations: ");
            for (int remainingValue = value; remainingValue > 0; remainingValue = lastValues[remainingValue]) {
                System.out.print((remainingValue - lastValues[remainingValue]) + " ");
            }
            System.out.println();
        }
    }
}
