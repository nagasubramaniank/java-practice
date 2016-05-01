// Problem ID: 126. Overlapping Intervals.
//
// Given a collection of Intervals,merge all the overlapping Intervals.
//
// For example:
// Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
//
// Make sure the returned intervals are sorted.
//
//
// Input:
//
// The first line contains an integer T, depicting total number of test cases. Then following T lines contains an
// integer N depicting the number of Intervals and next line followed by the intervals starting and ending positions 'x'
// and 'y' respectively.
//
// Output:
//
// Print the intervals after overlapping in sorted manner.
//
// Note: There should be a space at the end of output of every test case.
//
// Constraints:
//
// 1 ≤ T ≤ 30
// 1 ≤ N ≤ 100
// 0 ≤ x ≤ y ≤ 100
//
// Example:
//
// Input
// 1
// 4
// 1 3 2 4 6 8 9 10
//
// Output
// 1 4 6 8 9 10


package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P0126_OverlappingIntervals {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] A = new int[2 * N];

            for (int i = 0; i < 2 * N; i++) {
                A[i] = in.nextInt();
            }

            printOverlappingIntervals(A);
        }
    }

    private static void printOverlappingIntervals(int[] intervals) {
        Map<Integer, Integer> intervalStartEnd = new TreeMap<>();

        for (int i = 0; i < intervals.length; i += 2) {
            if (!intervalStartEnd.containsKey(intervals[i]) || intervalStartEnd.get(intervals[i]) < intervals[i + 1]) {
                intervalStartEnd.put(intervals[i], intervals[i + 1]);
            }
        }

        intervalStartEnd.put(Integer.MAX_VALUE, Integer.MAX_VALUE);

        int previousIntervalStart = -1, previousIntervalEnd = -1;

        for (Map.Entry<Integer, Integer> entry : intervalStartEnd.entrySet()) {

            if (previousIntervalEnd < entry.getKey()) {

                if (previousIntervalStart >= 0) {
                    System.out.print(previousIntervalStart + " " + previousIntervalEnd + " ");
                }

                previousIntervalStart = entry.getKey();
            }

            previousIntervalEnd = Math.max(previousIntervalEnd, entry.getValue());
        }

        System.out.println();
    }
}
