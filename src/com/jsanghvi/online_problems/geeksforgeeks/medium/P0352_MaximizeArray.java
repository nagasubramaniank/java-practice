// Problem ID: 352. Maximize the Array.
//
// You are given two arrays of numbers. You have to maximize the first array by using the elements from the second array such that the new array formed contains unique elements. For example, let the size of array be 'n'. Then the output should be n greatest but unique elements of both the arrays. The order of elements should be as explained in example below, i.e., giving the second array priority.
//
// Input:
// The first line of each input contains the number of test cases . The description of T test cases follows:
// The first line of each test case contains the size of the array (This is going to be the size of both the arrays).
// The second line of each test case contains the elements of the first array.
// The final line of each test case contains the elements of the second array.
//
// Output:
// Print the maximum elements giving second array higher priority. The order of appearance of elements is kept same in
// output as in input (See Example for better Understanding).
//
// Constraints:
// 1 <= T <= 20
// 1 <= N <= 10
// 0 <= Array1[i] <= 9
// 0 <= Array2[i] <= 9
//
// Example:
//
// Input:
//
// 2
// 5
// 7 4 8 0 1
// 9 7 2 3 6
// 4
// 6 7 5 3
// 5 6 2 9
//
// Output:
//
// 9 7 6 4 8
// 5 6 9 7

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.*;

public class P0352_MaximizeArray {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();
            final int[] array1 = new int[N];
            final int[] array2 = new int[N];

            for (int i = 0; i < N; i++) {
                array1[i] = in.nextInt();
            }

            for (int i = 0; i < N; i++) {
                array2[i] = in.nextInt();
            }

            printMaximizedArray(array1, array2);
        }
    }

    private static void printMaximizedArray(final int[] array1, final int[] array2) {
        final int size = array1.length;
        final Map<Integer, Integer> digitPositions = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < size; i++) {
            if (!digitPositions.containsKey(array2[i])) {
                digitPositions.put(array2[i], i);
            }
        }

        for (int i = 0; i < size; i++) {
            if (!digitPositions.containsKey(array1[i])) {
                digitPositions.put(array1[i], size + i);
            }
        }

        final Set<Integer> positions = new TreeSet<>();
        Iterator<Integer> values = digitPositions.values().iterator();

        for (int count = 0; count < size; count++) {
            positions.add(values.next());
        }

        for (int position : positions) {
            System.out.print((position < size ? array2[position] : array1[position - size]) + " ");
        }
        System.out.println();
    }
}
