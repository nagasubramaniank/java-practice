// Problem ID: 663. Fun with expression.
//
// Evaluate the expression given from left to right in the order the operators come. The expression consists of 4 basic
// operators +, /, *, -. But it is not certain that which will come first. Operators can come in any order.
//
// Input:
// First line consists of T test cases. The next T lines consists of the expressions in each line.
//
// Output:
// The answer should be the floor value of the expression's result.
//
// Constraints:
// 1 <= T <= 100
// 1 <= operand value <= 100
// 1 <= operators <= 4
//
// Example:
// Input:
// 3
// 10*20+10
// 16*5-5/15
// 4/5-8
//
// Output:
// 210
// 5
// -8

package com.jsanghvi.online_problems.geeksforgeeks.easy;

import java.util.Scanner;
import java.util.StringTokenizer;

public class P0663_EvaluateExpression {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printResult(in.next());
        }
    }

    private static void printResult(final String expression) {
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*/", true);
        double result = Double.parseDouble(tokenizer.nextToken());

        while (tokenizer.hasMoreElements()) {
            switch (tokenizer.nextToken().charAt(0)) {
                case '+':
                    result += Double.parseDouble(tokenizer.nextToken());
                    break;
                case '-':
                    result -= Double.parseDouble(tokenizer.nextToken());
                    break;
                case '*':
                    result *= Double.parseDouble(tokenizer.nextToken());
                    break;
                case '/':
                    result /= Double.parseDouble(tokenizer.nextToken());
                    break;
            }
        }

        System.out.println((int) Math.floor(result));
    }
}
