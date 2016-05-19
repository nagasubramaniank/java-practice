// Problem ID: 443. N meetings in one room.
//
// There is one meeting room in Flipkart. There are n meetings in the form of (S[i], F[i]) where S [i] is start time of
// meeting i and F [i] is finish time of meeting i. What is the maximum number of meetings that can be accommodated in
// the meeting room?
//
// Input:
// The first line of input consists number of the test cases. The description of T test cases is as follows:
// The first line consists of the size of the array, second line has the array containing the starting time of all the
// meetings each separated by a space, i.e., S [i]. And the third line has the array containing the finishing time of
// all the meetings each separated by a space, i.e., F [i].
//
// Output:
// In each separate line print the order in which the meetings take place separated by a space.
//
// Constraints:
// 1 ≤ T ≤ 70
// 1 ≤ N ≤ 100
// 1 ≤ S[i], F[i] ≤ 100000
//
// Example:
//
// Input:
// 2
// 6
// 1 3 0 5 8 5
// 2 4 6 7 9 9
// 8
// 75250 50074 43659 8931 11273 27545 50879 77924
// 112960 114515 81825 93424 54316 35533 73383 160252
//
// Output:
// 1 2 4 5
// 6 7 1

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Arrays;
import java.util.Scanner;

public class P0443_MaximizeMeetings {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] S = new int[N], F = new int[N];

            for (int i = 0; i < N; i++) {
                S[i] = in.nextInt();
            }

            for (int i = 0; i < N; i++) {
                F[i] = in.nextInt();
            }

            printMeetings(S, F);
        }
    }

    private static void printMeetings(final int[] startTimes, final int[] endTimes) {
        final int length = startTimes.length;
        final long[] combinedTimes = new long[length];
        for (int i = 0; i < length; i++) {
            combinedTimes[i] = getCombinedTime(endTimes[i], startTimes[i], i + 1);
        }

        Arrays.sort(combinedTimes);

        StringBuilder output = new StringBuilder();
        for (int i = 0, lastEndTime = Integer.MIN_VALUE; i < length; i++) {
            if (getStartTime(combinedTimes[i]) >= lastEndTime) {
                output.append(getIndex(combinedTimes[i])).append(' ');
                lastEndTime = getEndTime(combinedTimes[i]);
            }
        }

        System.out.println(output);
    }

    private static long getCombinedTime(final int endTime, final int startTime, final int index) {
        return endTime * 1000000000L + startTime * 1000L + index;
    }

    private static int getEndTime(final long combinedTime) {
        return (int) (combinedTime / 1000000000L);
    }

    private static int getStartTime(final long combinedTime) {
        return (int) ((combinedTime % 1000000000L) / 1000L);
    }

    private static int getIndex(final long combinedTime) {
        return (int) (combinedTime % 1000L);
    }
}
