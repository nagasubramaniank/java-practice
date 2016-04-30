// Problem ID: 480. Allocate minimum number of pages to each student.
//
// You are given N number of books. Every ith book has Pi number of pages. You have to allocate books to M number of
// students so that maximum number of pages allotted to a student is minimum. A book will be allocated to exactly one
// student. Each student has to be allocated at least one book.
//
// Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order.
//
// Input:
//
// The first line contains 'T' denoting the number of test cases. Then follows description of T test cases:
// Each case begins with a single positive integer N denoting the number of books.
// The second line contains N space separated positive integers denoting the pages of each book.
// And the third line contains another integer M, denoting the number of students.
//
// Output:
// For each test case, output a single line containing minimum number of pages each student has to read for
// corresponding test case.
//
// Constraints:
// 1 <= T <= 70
// 1 <= N <= 50
// 1 <= A[i] <= 250
// 1 <= M <= 50
//
// Example:
//
// Input:
// 1
// 4
// 12 34 67 90
// 2
//
// Output:
// 113
//
// Explanation: Allocation can be done in following ways:
//
// {12} and {34, 67, 90}     Maximum Pages = 191
// {12, 34} and {67, 90}     Maximum Pages = 157
// {12, 34, 67} and {90}     Maximum Pages = 113
//
// Therefore, the minimum of these cases is 113, which is selected as output.

package com.jsanghvi.online_problems.geeksforgeeks.hard;

import java.util.Scanner;

public class P0448_AllocateBooks {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();

            final int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            final int M = in.nextInt();

            printMinimumPages(A, M);
        }
    }

    private static void printMinimumPages(final int[] bookPages, final int numStudents) {

        if (numStudents > bookPages.length) {
            System.out.println(-1);
            return;
        }

        int maxBookPage = Integer.MIN_VALUE, sumBookPages = 0;

        for (int bookPage : bookPages) {
            if (maxBookPage < bookPage) {
                maxBookPage = bookPage;
            }

            sumBookPages += bookPage;
        }

        int minimumPages = Integer.MAX_VALUE;
        for (int lowPages = sumBookPages / bookPages.length,
             highPages = maxBookPage * ((bookPages.length / numStudents) + 1);
             lowPages <= highPages; ) {

            int pages = (lowPages + highPages) / 2;

            final int minimumStudents = getMinimumStudents(bookPages, pages);

            // If accommodated students is equal to number of student, still try to reduce the minimum page count.
            if (minimumStudents > numStudents) {
                lowPages = pages + 1;
            } else {
                highPages = pages - 1;
                minimumPages = pages;
            }
        }

        System.out.println(minimumPages);
    }

    private static int getMinimumStudents(final int[] bookPages, final int pages) {

        int minimumStudents = 1;
        int currentStudentPages = 0;

        for (int i = 0; i < bookPages.length; ) {

            if (currentStudentPages + bookPages[i] <= pages) {
                // If current student can be allotted current book.
                currentStudentPages += bookPages[i++];
            } else if (currentStudentPages <= 0) {
                // Else if current student was not allotted any book.
                // Return Integer.MAX_VALUE as pages will need to be increased.
                return Integer.MAX_VALUE;
            } else {
                // Else move to next student and reset number of pages allotted to this student.
                currentStudentPages = 0;
                minimumStudents += 1;
            }
        }

        return minimumStudents;
    }
}
