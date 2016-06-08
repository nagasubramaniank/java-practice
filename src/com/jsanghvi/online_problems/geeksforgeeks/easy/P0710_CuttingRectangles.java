// Problem ID: 710. Cutting Rectangles.
//
// Given a rectangle of dimensions a X b find the minimum number (n) of identical squares of maximum side that can be
// cut out from that rectangle so that no residue remains in the rectangle. Also find the dimension k of that square.
//
// Input:
//
// The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow. Each
// test case consists of a single line containing two space separated integers a and b denoting the dimensions of the
// rectangle.
//
// Output:
//
// For each test case print n and k (space separated ) in a new line.
//
// Constraints:
//
// 1 <= T <= 30
// 1 <= a,b <= 10^9
//
// Example:
//
// INPUT:
// 3
// 2 4
// 3 6
// 2 8
//
// OUTPUT:
// 2 2
// 2 3
// 4 2

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0710_CuttingRectangles {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printSquareCountSize(in.nextInt(), in.nextInt());
        }
    }

    private static void printSquareCountSize(final int length, final int breadth) {
        final long gcd = gcd(length, breadth);
        System.out.println(((length / gcd) * (breadth / gcd)) + " " + gcd);
    }

    private static long gcd(final long x, final long y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
