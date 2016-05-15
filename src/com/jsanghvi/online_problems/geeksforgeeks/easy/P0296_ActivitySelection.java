// Problem ID: 296. Activity Selection.
//
// Given N activities with their start and finish times. Select the maximum number of activities that can be performed
// by a single person, assuming that a person can only work on a single activity at a time.
//
// Note: The start time and end time of two activities may coincide.
//
// Input:
// The first line contains T denoting the number of test cases. Then follows description of test cases. First line is N
// number of activities then second line contains N numbers which are starting time of activities.Third line contains N
// finishing time of activities.
//
// Output:
// For each test case, output a single number denoting maximum activities which can be performed in new line.
//
// Constraints:
// 1 <= T <= 50
// 1 <= N <= 1000
// 1 <= A[i] <= 100
//
// Example:
// Input:
// 1
// 6
// 1 3 0 5 8 5
// 2 4 6 7 9 9
//
// Output:
// 4

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Arrays;
import java.util.Scanner;

public class P0296_ActivitySelection {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] startTimes = new int[N], endTimes = new int[N];

            for (int i = 0; i < N; i++) {
                startTimes[i] = in.nextInt();
            }

            for (int i = 0; i < N; i++) {
                endTimes[i] = in.nextInt();
            }

            printMaximumActivities(startTimes, endTimes);
        }
    }

    private static void printMaximumActivities(final int[] startTimes, final int[] endTimes) {
        final int length = startTimes.length;
        final int[] combinedTimes = new int[length];
        for (int i = 0; i < length; i++) {
            combinedTimes[i] = getCombinedTime(endTimes[i], startTimes[i]);
        }

        Arrays.sort(combinedTimes);

        int activities = 0;
        for (int i = 0, lastEndTime = Integer.MIN_VALUE; i < length; i++) {
            if (getStartTime(getStartTime(combinedTimes[i])) >= lastEndTime) {
                activities += 1;
                lastEndTime = getEndTime(combinedTimes[i]);
            }
        }

        System.out.println(activities);
    }

    private static int getCombinedTime(final int endTime, final int startTime) {
        return endTime * 10000 + startTime;
    }

    private static int getEndTime(final int combinedTime) {
        return combinedTime / 10000;
    }

    private static int getStartTime(final int combinedTime) {
        return combinedTime % 10000;
    }
}
