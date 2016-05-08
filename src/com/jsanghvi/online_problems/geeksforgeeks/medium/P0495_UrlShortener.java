// Problem ID: 495. Design a tiny URL or URL shortener.
//
// Design a system that takes big URLs like “http://www.geeksforgeeks.org/count-sum-of-digits-in-numbers-from-1-to-n/”
// and converts them into a short 6 character URL. It is given that URLs are stored in database and every URL has an
// associated integer id. So your program should take an integer id and generate a 6 character long URL.
//
// A URL character can be one of the following
// 1) A lower case alphabet [‘a’ to ‘z’], total 26 characters
// 2) An upper case alphabet [‘A’ to ‘Z’], total 26 characters
// 3) A digit [‘0′ to ‘9’], total 10 characters
//
// There are total 26 + 26 + 10 = 62 possible characters.
//
// So the task is to convert an integer (database id) to a base 62 number where digits of 62 base are
// "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
//
// Input:
// The first line of input contains an integer T denoting the number of test cases. And the second line consists of a
// long integer.
//
// Output:
// Print the shortened string in the first line and convert the shortened string back to ID (to make sure that your
// conversion works fine) and print that in the second line.
//
// Constraints:
// 1 ≤ T ≤ 70
// 1 ≤ N ≤ 4,294,967,295
//
// Example:
//
// Input:
// 1
// 12345
//
// Output:
// dnh
// 12345

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0495_UrlShortener {
    private static final String base62Symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printShortenedUrl(in.nextLong());
        }
    }

    private static void printShortenedUrl(final long urlId) {
        final StringBuilder base62Id = new StringBuilder(10);

        // Required to match with geeksforgeeks output.
        final int base10Id = (int) Math.min(urlId, Integer.MAX_VALUE);

        for (int id = base10Id; id > 0; id /= 62) {
            base62Id.insert(0, base62Symbols.charAt(id % 62));
        }

        System.out.println(base62Id);
        System.out.println(base10Id);
    }
}
