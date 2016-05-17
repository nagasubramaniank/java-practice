// Problem ID: 430. Column name from a given column number.
//
// Given a positive integer, return its corresponding column title as appear in an Excel sheet.
// MS Excel columns has a pattern like A, B, C, ..., Z, AA, AB, AC, ...., AZ, BA, BB, ..., ZZ, AAA, AAB, ..... etc. In
// other words, column 1 is named as “A”, column 2 as “B”, column 27 as “AA”.
// 
// Input:
// The first line of each input consists of the test cases. And, the second line consists of a number N.
// 
// Output:
// In each separate line print the corresponding column title as it appears in an Excel sheet.
// 
// Constraints:
// 1 ≤ T ≤ 70
// 1 ≤ N ≤ 4294967295
// 
// Example:
// 
// Input:
// 2
// 28
// 13
// 
// Output:
// AB
// M

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;

public class P0430_ExcelColumnName {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printExcelColumnName(in.nextLong());
        }
    }

    private static void printExcelColumnName(final long columnNumber) {

        StringBuilder columnName = new StringBuilder();

        for (long num = columnNumber - 1; num >= 0; num = (num / 26) - 1) {
            columnName.insert(0, (char) ((num % 26) + 'A'));
        }

        System.out.println(columnName);
    }
}
