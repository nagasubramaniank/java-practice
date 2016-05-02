// Problem ID: 655. Path of more than k length.
//
// Given a graph, a source vertex in the graph and a number k, find if there is a simple path (without any cycle)
// starting from given source and ending at any other vertex.
//
// Input:
// First Line contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains
// two lines. First Line contains three integers V, E and k representing vertices, edges of the graph and the required
// minimum length respectively. Second line contains 3 * E integers containing the information of all edges in the
// graph. Information of a single edge is a triplet in the following format: (Source Destination Distance). See example
// for more understanding.
//
// Output:
// For each test case print 1 if the path of at least k distance exists, else print 0 in a new line.
//
// Constraints:
// 1 <= T <= 30
// 2 <= V <= 5
// 1 <= E <= 20
// 1 <= k <= 100
//
// Input:
// 2
// 8 14 60
// 0 1 4 0 7 8 1 2 8 1 7 11 2 3 7 2 5 4 2 8 2 3 4 9 3 5 14 4 5 10 5 6 2 6 7 1 6 8 6 7 8 7
// 4 3 8
// 0 1 5 1 2 1 2 3 1
//
// Output:
// 1
// 0
//
// Explanation:
// Test Case 1: There exists a path 4 -> 3 -> 5 -> 6 -> 8 -> 2 -> 1 -> 7 -> 0 which has a total distance of 60
// Test Case 2: There exists no path which has a distance of 8

package com.jsanghvi.online_problems.geeksforgeeks.hard;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P0655_LongerPaths {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int V = in.nextInt();
            final int E = in.nextInt();
            final int K = in.nextInt();
            final Graph graph = new Graph(V);

            for (int edge = 0; edge < E; edge++) {
                graph.add(in.nextInt(), in.nextInt(), in.nextInt());
            }

            printIsLongerPath(graph, K);
        }
    }

    private static void printIsLongerPath(final Graph graph, final int pathLength) {
        final Set<Integer> visitedVertices = new HashSet<>();
        System.out.println(isLongerPath(graph, pathLength, 0, visitedVertices) ? 1 : 0);
    }

    private static boolean isLongerPath(final Graph graph, final int pathLength, final int source,
                                        Set<Integer> visitedVertices) {

        if (pathLength <= 0) {
            return true;
        }

        visitedVertices.add(source);

        final int[] adjacentDistances = graph.adjacentDistances(source);
        for (int destination = 0; destination < adjacentDistances.length; destination++) {
            if (adjacentDistances[destination] > 0 && !visitedVertices.contains(destination)) {
                if (isLongerPath(graph, pathLength - adjacentDistances[destination], destination, visitedVertices)) {
                    return true;
                }
            }
        }

        visitedVertices.remove(source);
        return false;
    }

    private static class Graph {
        private final int[][] adjacencyMatrix;

        public Graph(final int vertices) {
            adjacencyMatrix = new int[vertices][vertices];
        }

        public void add(final int vertex1, final int vertex2, final int distance) {
            adjacencyMatrix[vertex1][vertex2] = distance;
            adjacencyMatrix[vertex2][vertex1] = distance;
        }

        public int[] adjacentDistances(final int vertex) {
            return adjacencyMatrix[vertex];
        }
    }
}
