// Problem 3. Print Valid Parentheses
//
// Print all combinations of N pairs of parentheses.

package com.jsanghvi.algorithms.backtracking;

public class PrintValidParentheses {
    public static void main(String[] args) {
        printParentheses(4);
    }

    private static void printParentheses(final int numParentheses) {
        printParentheses(new StringBuilder(), numParentheses, 0);
    }

    private static void printParentheses(final StringBuilder parenthesesString, final int remainingLeft,
                                         final int remainingRight) {

        if (remainingLeft == 0 && remainingRight == 0) {
            System.out.println(parenthesesString);
            return;
        }

        if (remainingLeft > 0) {
            parenthesesString.append('(');
            printParentheses(parenthesesString, remainingLeft - 1, remainingRight + 1);
            parenthesesString.setLength(parenthesesString.length() - 1);
        }

        if (remainingRight > 0) {
            parenthesesString.append(')');
            printParentheses(parenthesesString, remainingLeft, remainingRight - 1);
            parenthesesString.setLength(parenthesesString.length() - 1);
        }
    }
}
