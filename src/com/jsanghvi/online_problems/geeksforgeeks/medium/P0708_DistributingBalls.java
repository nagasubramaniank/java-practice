// Problem ID: 708. Distributing balls.
//
// John is a very calm person. He loves children very much. As his birthday is coming, he decided to give some gifts to
// the poor children and wants to make them happy by giving them the balls. But his enemy does not like his idea and
// therefore he wants to destroy John's Plan. So, his enemy takes away the balls as much as he can in the absence of
// John. John becomes very sad and thinks how he would distribute the remaining balls so that all the children feel
// happy. Therefore our task is to find the number of ways of distributing the balls. If he can distribute it, output
// number of ways else print "-1" without quotes.
//
// Input:
// First line of the input contains an integer T, denoting number of test cases. Then T test cases follow. Each test
// case consists of two lines. The first line of each test case consists of three integers m, n and p denoting total
// number of balls, number of children and the balls enemy has taken respectively. The second line of each test case
// consists of n space separated integers denoting minimum number of balls needed by a child numbered i, where
// 1 <= i <= n.
//
// Output:
// If he can distribute, print the number of ways % 1000000007, else print "-1" without quotes.
//
// Constraints:
// 1 <= T <= 100
// 1 <= m <= 1000
// 2 <= n <= 100
// 1 <= p <= 1000
//
// Example:
//
// Input
// 2
// 13 4 5
// 2 3 1 3
// 30 10 14
// 2 2 1 1 1 2 2 3 1 1
//
// Output
// -1
// 1

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.math.BigInteger;
import java.util.Scanner;

public class P0708_DistributingBalls {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int M = in.nextInt();
            final int N = in.nextInt();
            final int P = in.nextInt();
            final int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            printPossibleDistributions(A, M, P);
        }
    }

    private static void printPossibleDistributions(final int[] requiredBalls, final int totalBalls,
                                                   final int removedBalls) {
        int remainingBalls = totalBalls - removedBalls;
        for (int requiredBall : requiredBalls) {
            remainingBalls -= requiredBall;
        }

        if (remainingBalls < 0) {
            System.out.println(-1);
            return;
        }

        // Distributing x balls among y children is just like having (x + y - 1) balls in a queue and removing a
        // combination of (y - 1) balls from the queue. They y partitions created by removing balls can be offered to
        // every child.

        final int children = requiredBalls.length;
        final BigInteger answer = nChooseK(remainingBalls + children - 1, children - 1)
                .mod(BigInteger.valueOf(1000000007));

        System.out.println(answer);
    }

    private static BigInteger nChooseK(final int N, int K) {
        BigInteger answer = BigInteger.ONE;
        K = Math.min(N - K, K);

        for (int k = 0; k < K; k++) {
            answer = answer.multiply(BigInteger.valueOf(N - k)).divide(BigInteger.valueOf(k + 1));
        }

        return answer;
    }
}
