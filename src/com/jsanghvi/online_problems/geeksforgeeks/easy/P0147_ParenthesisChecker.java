// Problem ID: 147. Parenthesis Checker.
//
// Given an expression string exp, examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct. For
// example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”
//
// Input:
//
// The first line of input contains an integer T denoting the number of test cases. Each test case consist of a string
// of expression, in a separate line.
//
// Output:
//
// Print 'balanced' without quotes if pair of parenthesis are balanced else print 'not balanced' in a separate line.
//
// Constraints:
//
// 1 ≤ T ≤ 30
// 1 ≤ |s| ≤ 100
//
// Example:
//
// Input
// 1
// {([])}
//
// Output
// balanced

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;
import java.util.Stack;

public class P0147_ParenthesisChecker {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printIsBalancedExpression(in.next());
        }
    }

    private static void printIsBalancedExpression(final String expression) {
        char[] expressionArray = expression.toCharArray();
        Stack<Character> expectedParenthesis = new Stack<>();

        for (char parenthesis : expressionArray) {
            if (parenthesis == '{') {
                expectedParenthesis.push('}');
            } else if (parenthesis == '(') {
                expectedParenthesis.push(')');
            } else if (parenthesis == '[') {
                expectedParenthesis.push(']');
            } else {
                if (expectedParenthesis.empty() || parenthesis != expectedParenthesis.pop()) {
                    System.out.println("not balanced");
                    return;
                }
            }
        }

        System.out.println(expectedParenthesis.empty() ? "balanced" : "not balanced");
    }
}
