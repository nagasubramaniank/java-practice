// Problem 3. Longest Increasing Subsequence
//
// Given a sequence of n real numbers A(1) ... A(n), determine a subsequence (not necessarily contiguous) of maximum
// length in which the values in the subsequence form a strictly increasing sequence.

package com.jsanghvi.algorithms.dynamic_programming;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] sequence = new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        printLongestSubsequence(sequence);
    }

    private static void printLongestSubsequence(final int[] sequence) {
        int[] longestSequenceSizes = new int[sequence.length];
        int[] lastIndexes = new int[sequence.length];

        int longestSequenceSize = Integer.MIN_VALUE;
        int longestSequenceEndIndex = -1;

        for (int endIndex = 0; endIndex < sequence.length; endIndex++) {
            longestSequenceSizes[endIndex] = 1;
            lastIndexes[endIndex] = -1;

            for (int lastIndex = 0; lastIndex < endIndex; lastIndex++) {
                if (sequence[lastIndex] < sequence[endIndex]
                        && longestSequenceSizes[endIndex] < longestSequenceSizes[lastIndex] + 1) {

                    longestSequenceSizes[endIndex] = longestSequenceSizes[lastIndex] + 1;
                    lastIndexes[endIndex] = lastIndex;
                }
            }

            if (longestSequenceSize < longestSequenceSizes[endIndex]) {
                longestSequenceSize = longestSequenceSizes[endIndex];
                longestSequenceEndIndex = endIndex;
            }
        }

        System.out.print("Input Sequence: ");
        for (int number : sequence) {
            System.out.print(number + " ");
        }
        System.out.println();

        // Use Deque class to show numbers in sequence in increasing order.
        Deque<Integer> longestSequenceIndexes = new ArrayDeque<>();
        for (int index = longestSequenceEndIndex; index >= 0; index = lastIndexes[index]) {
            longestSequenceIndexes.push(index);
        }

        System.out.print("Longest Increasing Subsequence: ");
        for (int index : longestSequenceIndexes) {
            System.out.print(sequence[index] + " ");
        }
        System.out.println();
    }
}
