// Problem ID: 669. Number to Word.
//
// Given number into words. For example, if “1234” is given as input, output should be “one thousand two hundred and
// thirty four”
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is N.
//
// Output:
//
// Print the number into words (in small letter).
//
// Constraints:
//
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 9999
//
// Example:
//
// Input:
// 2
// 2
// 142
//
// Output:
// two
// one hundred and forty two

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0669_NumberToWord {
    private static String[] unitsWord = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen"};
    private static String[] tensWord = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
            "ninety"};

    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printNumberWord(in.nextInt());
        }
    }

    private static void printNumberWord(final int number) {
        final int thousands = (number % 10000) / 1000;
        final int hundreds = (number % 1000) / 100;
        final int tens = (number % 100) / 10;
        final int units = number % 10;

        StringBuilder numberWord = new StringBuilder();

        if (thousands > 0) {
            numberWord.append(unitsWord[thousands]).append(" thousand");
        }

        if (hundreds > 0) {
            if (numberWord.length() > 0) {
                numberWord.append(" ");
            }
            numberWord.append(unitsWord[hundreds]).append(" hundred");
        }

        if (numberWord.length() > 0 && (tens > 0 || units > 0)) {
            numberWord.append(" and");
        }

        if (tens > 1) {
            if (numberWord.length() > 0) {
                numberWord.append(" ");
            }
            numberWord.append(tensWord[tens]);
        }


        if (tens == 1 || units > 0) {
            if (numberWord.length() > 0) {
                numberWord.append(" ");
            }
            numberWord.append(unitsWord[(tens == 1 ? 10 : 0) + units]);
        }

        System.out.println(numberWord);
    }
}
