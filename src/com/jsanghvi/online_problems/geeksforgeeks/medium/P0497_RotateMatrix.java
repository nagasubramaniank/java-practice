// Problem ID: 497. Rotate a 2D array without using extra space.
//
// You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise). You need to do
// this in place. Note that if you end up using an additional array, you will only receive partial score.
//
// Example:
// If the array is 1 2 3 4 5 6 7 8 9 then the rotated array becomes: 7 4 1 8 5 2 9 6 3
//
// Input:
// The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line
// contains an integer 'N' denoting the size of the 2D square matrix. And in the second line, the elements of the matrix
// A[][], each separated by a space in row major form.
//
// Output:
// Print the elements of the rotated array row wise, each element separated by a space.
//
// Constraints:
// 1 ≤ T ≤ 70
// 1 ≤ N ≤ 10
// 1 ≤ A [ i ][ j ] ≤ 100
//
// Example:
//
// Input:
// 1
// 3
// 1 2 3 4 5 6 7 8 9
//
// Output:
// 7 4 1 8 5 2 9 6 3

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.Scanner;

public class P0497_RotateMatrix {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[][] matrix = new int[N][N];

            for (int row = 0; row < N; row++) {
                for (int column = 0; column < N; column++) {
                    matrix[row][column] = in.nextInt();
                }
            }

            printRotatedMatrix(matrix);
        }
    }

    private static void printRotatedMatrix(int[][] matrix) {
        final int size = matrix.length;

        for (int row = 0; row < size / 2; row++) {
            for (int column = 0; column < (size + 1) / 2; column++) {
                int temp = matrix[row][column];
                matrix[row][column] = matrix[size - column - 1][row];
                matrix[size - column - 1][row] = matrix[size - row - 1][size - column - 1];
                matrix[size - row - 1][size - column - 1] = matrix[column][size - row - 1];
                matrix[column][size - row - 1] = temp;
            }
        }

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                System.out.print(matrix[row][column] + " ");
            }
        }

        System.out.println();
    }
}
