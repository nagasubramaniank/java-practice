// Problem ID: 116. Rank the Permutation.
//
// Given a string, find the rank of the string amongst its permutations sorted lexicographically. Return 0 if the
// characters are repeated in the string.
//
// For example:
//
// Input : 'acb'
// Output : 2
//
// The order permutations with letters 'a', 'c', and 'b' :
// abc
// acb
// bac
// bca
// cab
// cba
//
// The answer might not fit in an integer, so return your answer % 1000003
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases. Each test case consist of a string
// in 'lowercase' only in a separate line.
//
// Output:
//
// Print the rank of the string amongst its permutations.
//
// Constraints:
//
// 1 ≤ T ≤ 50
// 1 ≤ |s| ≤ 15
//
// Example:
//
// Input:
// 2
// abc
// acb
//
// Output:
// 1
// 2

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0116_PermutationRank {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();
        in.nextLine();

        for (int test = 0; test < T; test++) {
            printPermutationRank(in.nextLine());
        }
    }

    private static void printPermutationRank(final String string) {

        if (doesAnyCharacterRepeats(string)) {
            System.out.println(0);
            return;
        }

        long rank = 1, product = 1;
        for (int charactersOnRight = 1; charactersOnRight < string.length(); charactersOnRight++) {
            product = product * charactersOnRight;
            rank += product * lesserCharactersOnRight(string, string.length() - charactersOnRight - 1);
        }

        System.out.println(rank % 1000003);
    }

    private static int lesserCharactersOnRight(final String string, final int position) {

        int count = 0;
        char character = string.charAt(position);
        for (int i = position + 1; i < string.length(); i++) {
            if (string.charAt(i) < character) {
                count += 1;
            }
        }

        return count;
    }

    private static boolean doesAnyCharacterRepeats(final String string) {
        boolean[] characterExists = new boolean[26];

        for (int i = 0; i < string.length(); i++) {
            if (characterExists[string.charAt(i) - 'a']) {
                return true;
            }

            characterExists[string.charAt(i) - 'a'] = true;
        }

        return false;
    }
}
