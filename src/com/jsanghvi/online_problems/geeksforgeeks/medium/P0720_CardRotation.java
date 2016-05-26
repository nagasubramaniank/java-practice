// Problem ID: 720. Card rotation.
//
// Given a sorted deck of cards numbered 1 to N.
// 1) We pick up 1 card and put it on the back of the deck.
// 2) Now, we pick up another card, it turns out to be card numbered 1, we put it outside the deck.
// 3) Now we pick up 2 cards and put it on the back of the deck.
// 4) Now, we pick up another card and it turns out to be card numbered 2, we put it outside the deck.
//
// We perform this step till the last card.
//
// If such arrangement of decks is possible, output the arrangement, if it is not possible for a particular value of N
// then output -1.
//
// Input:
// The first line of the input contains the number of test cases 'T', after that 'T' test cases follow.
// Each line of the test case consists of a single line containing an integer 'N'.
//
// Output:
// If such arrangement of decks is possible, output the arrangement, if it is not possible for a particular value of n
// then output -1.
//
// Constraints:
// 1 <= T <= 100;
// 1 <= N <= 1000;
//
// Example:
//
// Input:
// 2
// 4
// 5
//
// Output:
//
// 2 1 4 3
// 3 1 4 5 2

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0720_CardRotation {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            printCardPositions(in.nextInt());
        }
    }

    private static void printCardPositions(final int cards) {
        int[] cardAt = new int[cards];

        for (int picks = 1, position = 0; picks < cards + 1; picks++) {
            int picked = 0;
            while (true) {
                if (cardAt[position % cards] == 0) {
                    picked += 1;
                }

                if (picked > picks) {
                    break;
                }

                position += 1;
            }

            cardAt[position % cards] = picks;
            position += 1;
        }

        for (int card : cardAt) {
            System.out.print(card + " ");
        }
        System.out.println();
    }
}
