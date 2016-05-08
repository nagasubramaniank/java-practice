// Problem ID: 496. Nuts and Bolts Problem.
//
// Given a set of N nuts of different sizes and N bolts of different sizes. There is a one-one mapping between nuts and
// bolts. Match nuts and bolts efficiently. Comparison of a nut to another nut or a bolt to another bolt is not allowed.
// It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.
//
// Input:
//
// The first line contains 'T' denoting the number of test cases. Then follows description of T test cases. Each case
// begins with a single positive integer N denoting the number of nuts/bolts. Then follows the array of nuts, each
// element separated by a space. And finally the bolts array, again, each element is separated by a space here.
//
// Array of Nuts/Bolts can only consist of the following elements: {'@', '#', '$', '%', '^', '&', '~', '*', '!'} and no
// element can be repeated.
//
// Output:
// For each test case, output the matched array of nuts and bolts in separate lines, where each element in the array is
// separated by a space. Print the elements in the following order ! # $ % & * @ ^ ~
//
// Constraints:
// 1 <= T <= 70
// 1 <= N <= 9
//
// Example:
//
// Input:
// 2
// 5
// @ % $ # ^
// % @ # $ ^
// 9
// ^ & % @ # * $ ~ !
// ~ # @ % & * $ ^ !
//
// Output:
// # $ % @ ^
// # $ % @ ^
// ! # $ % & * @ ^ ~
// ! # $ % & * @ ^ ~

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P0496_NutsAndBolts {

    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final char[] nuts = new char[N], bolts = new char[N];

            for (int i = 0; i < N; i++) {
                nuts[i] = in.next().charAt(0);
            }

            for (int i = 0; i < N; i++) {
                bolts[i] = in.next().charAt(0);
            }

            printNutsAndBolts(nuts, bolts);
        }
    }

    private static void printNutsAndBolts(final char[] nuts, final char[] bolts) {
        final char[] order = {'!', '#', '$', '%', '&', '*', '@', '^', '~'};
        final Set<Character> nutsSet = new HashSet<>(), boltsSet = new HashSet<>();

        for (int i = 0; i < nuts.length; i++) {
            nutsSet.add(nuts[i]);
            boltsSet.add(bolts[i]);
        }

        for (char character : order) {
            if (nutsSet.contains(character)) {
                System.out.print(character + " ");
            }
        }
        System.out.println();

        for (char character : order) {
            if (boltsSet.contains(character)) {
                System.out.print(character + " ");
            }
        }
        System.out.println();
    }
}
