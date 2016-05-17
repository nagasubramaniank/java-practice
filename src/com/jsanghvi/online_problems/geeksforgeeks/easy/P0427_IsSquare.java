// Problem ID: 427. Is Square.
//
// Given four different points in space. Find these points can form a square or not.
//
// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case contains x1, y1, x2, y2, x3, y3, x4, y4 (four points coordinates).
//
// Output:
// Print "Yes" (without quotes) if it is square else "No".
//
// Constraints:
// 1 ≤ T ≤ 30
// 1 ≤ x1, x2, x3, x4, y1, y2, y3, y4 ≤ 100
//
// Example:
//
// Input
// 1
// 20 10 10 20 20 20 10 10
//
// Output
// Yes

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Arrays;
import java.util.Scanner;

public class P0427_IsSquare {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int[][] coordinates = new int[4][2];
            for (int point = 0; point < 4; point++) {
                coordinates[point][0] = in.nextInt();
                coordinates[point][1] = in.nextInt();
            }

            printIsSquare(coordinates);
        }
    }

    private static void printIsSquare(final int[][] coordinates) {

        // Copy the points into a format to support sorting the points.
        final int[] points = new int[4];
        for (int point = 0; point < 4; point++) {
            points[point] = normalizePoint(coordinates[point]);
        }
        Arrays.sort(points);

        if (distance(points[0], points[1]) == distance(points[0], points[2])
                && distance(points[0], points[2]) == distance(points[2], points[3])
                && distance(points[0], points[3]) == distance(points[1], points[2])) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static int normalizePoint(final int[] point) {
        return 1000 * point[0] + point[1];
    }

    private static double distance(final int normalizedPoint1, final int normalizedPoint2) {
        double distance = Math.sqrt(Math.pow(normalizedPoint2 % 1000 - normalizedPoint1 % 1000, 2)
                + Math.pow(normalizedPoint2 / 1000 - normalizedPoint1 / 1000, 2));

        return Math.round(distance * 1000000) / 1000000;
    }
}
