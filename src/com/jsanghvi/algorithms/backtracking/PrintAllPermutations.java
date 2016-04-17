// Problem 2. Print All Permutations
//
// Print all permutations of input string.

package com.jsanghvi.algorithms.backtracking;

public class PrintAllPermutations {
    public static void main(String[] args) {
        printPermutations("SLAM");
    }

    private static void printPermutations(final String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        printPermutations(stringBuilder, 0);
    }

    private static void printPermutations(final StringBuilder string, int startIndex) {
        if (startIndex == string.length()) {
            System.out.println(string);
            return;
        }

        for (int index = startIndex; index < string.length(); index++) {
            swapCharacters(string, startIndex, index);
            printPermutations(string, startIndex + 1);
            swapCharacters(string, startIndex, index);
        }
    }

    private static void swapCharacters(StringBuilder string, int index1, int index2) {
        char temp = string.charAt(index1);
        string.setCharAt(index1, string.charAt(index2));
        string.setCharAt(index2, temp);
    }
}
