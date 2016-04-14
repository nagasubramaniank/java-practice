// Problem 1. Maximum Value Contiguous Subsequence
//
// Given a sequence of n real numbers A(1) ... A(n), determine a contiguous subsequence A(i) ... A(j) for which the sum
// of elements in the subsequence is maximized.

package com.jsanghvi.algorithms.dynamic_programming;

class MaximumValueContiguousSubsequence {
    public static void main(String[] args) {
        int[] sequence = new int[]{0, -4, -2, 6, 1, -5, -3, 7};
        printMaxSubsequence(sequence);

        sequence = new int[]{0, -4, 2, 6, -1, -5, 3, 7};
        printMaxSubsequence(sequence);
    }

    private static void printMaxSubsequence(final int[] sequence) {
        int maxTill = Integer.MIN_VALUE, maxTillStartIndex = 0, maxTillEndIndex = -1;
        int maxAll = Integer.MIN_VALUE, maxAllStartIndex = 0, maxAllEndIndex = -1;

        for (int i = 0; i < sequence.length; i++) {
            if (maxTill <= 0) {
                maxTill = sequence[i];
                maxTillStartIndex = i;
                maxTillEndIndex = i;
            } else {
                maxTill += sequence[i];
                maxTillEndIndex = i;
            }

            if (maxAll < maxTill) {
                maxAll = maxTill;
                maxAllStartIndex = maxTillStartIndex;
                maxAllEndIndex = maxTillEndIndex;
            }
        }

        printSubsequence("Sequence: ", sequence, 0, sequence.length - 1);
        printSubsequence("Maximum Value Contiguous Subsequence: ", sequence, maxAllStartIndex, maxAllEndIndex);
        System.out.println();
    }

    private static void printSubsequence(String prefix, int[] sequence, int startIndex, int endIndex) {
        System.out.print(prefix);
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(sequence[i] + " ");
        }
        System.out.println();
    }
}
