// Problem ID: 173. Head to Tail Ordering.
//
// A head to tail ordering of strings is the one in which the last letter of the previous word is the same as the first
// letter of the following word. E.g. ‘Geekforgeeks’ can be followed by ‘software’. The task is to write a code to
// accept a set of finite strings and determine if such an ordering is possible by arranging them in a head to tail
// sequence.
//
// Input:
//
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line
// contains an integer 'N' denoting the size of array. The next 'N' lines contains N strings. Only letters 'a' through
// 'z' will appear in the word. The same word may appear several times in the list.
//
// Output:
//
// "Head to tail ordering is possible." if it is possible to arrange all the words in a sequence such that the first
// letter of each word is equal to the last letter of the previous word. All the plates from the list must be used, each
// exactly once else output "Head to tail ordering is not possible.". Output of all the test cases should be in a
// separate line and don't print quotes.
//
// Constraints:
//
// 1 <= T <= 30
// 1 <= N <= 100
// 1 <= Length(String) <= 100
//
// Example:
//
// Input:
// 1
// 3
// big
// smart
// geeks
//
// Output:
// Head to tail ordering is possible.
//
// Explanation:
// The order will be: big  geeks  smart


package com.jsanghvi.online_problems.geeksforgeeks.hard;

import java.util.Scanner;

public class P0173_HeadToTail {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final String[] words = new String[N];

            for (int i = 0; i < N; i++) {
                words[i] = in.next();
            }

            printIsOrderingPossible(words);
        }
    }

    private static void printIsOrderingPossible(final String[] words) {
        final int[][] startEndWordCount = new int[26][26];

        for (final String word : words) {
            startEndWordCount[word.charAt(0) - 'a'][word.charAt(word.length() - 1) - 'a'] += 1;
        }

        // Pick any word. It should be present in the word chain at some position.
        if (nextInChain(words.length, '\0', true, words[0], startEndWordCount)) {
            System.out.println("Head to tail ordering is possible.");
        } else {
            System.out.println("Head to tail ordering is not possible.");
        }
    }

    private static boolean nextInChain(final int remainingWords, char lastLetter, boolean isRightDirection,
                                       final String startWord, final int[][] startEndWordCount) {

        if (remainingWords == 0) {
            return true;
        }

        if (isRightDirection) {
            final char start = lastLetter >= 'a' ? lastLetter : startWord.charAt(0);
            for (char end = 'a'; end <= 'z'; end++) {
                if (startEndWordCount[start - 'a'][end - 'a'] > 0) {
                    startEndWordCount[start - 'a'][end - 'a'] -= 1;
                    if (nextInChain(remainingWords - 1, end, true, startWord, startEndWordCount)) {
                        return true;
                    }
                    startEndWordCount[start - 'a'][end - 'a'] += 1;
                }
            }

            // Reached the end in right direction. Now start in left direction from start word;
            lastLetter = '\0';
            isRightDirection = false;
        }

        if (!isRightDirection) {
            final char end = lastLetter >= 'a' ? lastLetter : startWord.charAt(0);
            for (char start = 'a'; start <= 'z'; start++) {
                if (startEndWordCount[start - 'a'][end - 'a'] > 0) {
                    startEndWordCount[start - 'a'][end - 'a'] -= 1;
                    if (nextInChain(remainingWords - 1, start, false, startWord, startEndWordCount)) {
                        return true;
                    }
                    startEndWordCount[start - 'a'][end - 'a'] += 1;
                }
            }
        }

        return false;
    }
}
