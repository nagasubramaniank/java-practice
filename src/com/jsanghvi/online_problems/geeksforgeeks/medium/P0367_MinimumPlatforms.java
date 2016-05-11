// Problem ID: 367. Minimum Platforms.
//
// Given arrival and departure times of all trains that reach a railway station, find the minimum number of platforms
// required for the railway station so that no train waits.
//
// Input:
//
// First line will contain a number T, the number of test cases.
// Each test case will contain a number N, the number of trains.
// Next two lines will consist of N space separated time intervals denoting arrival and departure times respectively.
// NOTE: Time intervals are in 24 hour format(hhmm),preceding zeros are insignificant.
// Consider the example for better understanding of input.
//
// Output:
// Print the required answer in separated line.
//
// Constraints:
// 1 <= T <= 80
// 1 <= N <= 5000
// 1 <= A[i] <= 5000
//
// Example:
//
// INPUT:
// 1
// 6
// 900  940 950  1100 1500 1800
// 910 1200 1120 1130 1900 2000
//
// OUTPUT:
// 3

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P0367_MinimumPlatforms {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] arrivals = new int[N];
            final int[] departures = new int[N];

            for (int i = 0; i < N; i++) {
                arrivals[i] = in.nextInt();
            }

            for (int i = 0; i < N; i++) {
                departures[i] = in.nextInt();
            }

            printMinimumPlatforms(arrivals, departures);
        }
    }

    // Following function does not pass geeksforgeeks test.

    private static void printMinimumPlatforms(final int[] arrivals, final int[] departures) {
        Map<Integer, Integer> platformDifferences = new TreeMap<>();

        for (int i = 0; i < arrivals.length; i++) {
            final int arrival = arrivals[i] % 2400;
            final int departure = departures[i] % 2400;

            platformDifferences.put(arrival,
                    (platformDifferences.containsKey(arrival) ? platformDifferences.get(arrival) : 0) + 1);
            platformDifferences.put(departure,
                    (platformDifferences.containsKey(departure) ? platformDifferences.get(departure) : 0) - 1);

            if (arrival > departure) {
                platformDifferences.put(0,
                        (platformDifferences.containsKey(0) ? platformDifferences.get(0) : 0) + 1);
                platformDifferences.put(2400,
                        (platformDifferences.containsKey(2400) ? platformDifferences.get(2400) : 0) - 1);
            }
        }

        int platforms = 0, maximumPlatforms = 0;
        for (int platformDifference : platformDifferences.values()) {
            platforms += platformDifference;
            maximumPlatforms = Math.max(maximumPlatforms, platforms);
        }

        System.out.println(maximumPlatforms);
    }
}
