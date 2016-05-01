// Problem ID: 117. Excel Sheet.
//
// Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
// For example:
//
// 1 -> A
// 2 -> B
// 3 -> C
// ...
// 26 -> Z
// 27 -> AA
// 28 -> AB
//
// NOTE: The alphabets are all in uppercase.
//
// Input:
//
// The first line contains an integer T, depicting total number of test cases. Then following T lines contains an
// integer N.
//
// Output:
//
// Print the string corresponding to the column number.
//
// Constraints:
//
// 1 ≤ T ≤ 40
// 1 ≤ N ≤ 10000000
//
// Example:
//
// Input
// 1
// 51
//
// Output
// AY

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0117_ExcelColumnName {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printExcelColumnName(in.nextInt());
        }
    }

    private static void printExcelColumnName(final int columnNumber) {

        StringBuilder columnName = new StringBuilder();

        for (int num = columnNumber - 1; num >= 0; num = (num / 26) - 1) {
            columnName.insert(0, (char) ((num % 26) + 'A'));
        }

        System.out.println(columnName);
    }
}
