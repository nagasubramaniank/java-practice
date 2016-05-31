// Problem ID: 761. Connecting nodes.
//
// Given a graph containing N nodes and M bi-directional edges, where each edge connects two different nodes. Find out
// the minimum number of new edges to be constructed such that you can start from node 1 and visit all the edges and
// return to node 1, and in this process you should not traverse any edge more than once. Remember that there can be
// multiple edges between two nodes and the graph can have disconnected components, and it should also be ensured that
// all the nodes in the graph are visited.
//
// Input:
//
// The first line of the input consists of a single integer T, denoting the number of test cases. Then T test cases
// follow. Each test case consists of two lines. The first line of each test case consists of two space separated
// integers N and M, denoting the number of nodes and the number of edges respectively. The Second line of each test
// case contains 2*M space separated integers denoting the edges as u1 v1 u2 v2 u3 v3....
//
// Output:
//
// For each test case, output a single line containing an integer, denoting the minimum number of new edges required to
// be constructed.
//
// Constraints:
// 1 ≤ T ≤ 5
// 1 ≤ N,M ≤ 10^5
// 1 ≤ u,v ≤ N
//
// Example:
//
// Input
// 1
// 4 3
// 1 2 2 3 3 4
//
// Output
// 1
//
// Explanation:
//
// For the above test case a new edge is constructed between cities 1 and 4.

package com.jsanghvi.online_problems.geeksforgeeks.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P0761_ConnectingNodes {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int test = 0; test < T; test++) {
            final int N = in.nextInt();

            @SuppressWarnings("unchecked")
            final Map<Integer, Integer>[] adjacencyList = (Map<Integer, Integer>[]) new Map<?, ?>[N];

            for (int vertex = 0; vertex < N; vertex++) {
                adjacencyList[vertex] = new HashMap<>();
            }

            final int M = in.nextInt();
            for (int edge = 0; edge < M; edge++) {
                final int U = in.nextInt(), V = in.nextInt();

                if (!adjacencyList[U - 1].containsKey(V - 1)) {
                    adjacencyList[U - 1].put(V - 1, 1);
                } else {
                    adjacencyList[U - 1].put(V - 1, adjacencyList[U - 1].get(V - 1) + 1);
                }

                if (!adjacencyList[V - 1].containsKey(U - 1)) {
                    adjacencyList[V - 1].put(U - 1, 1);
                } else {
                    adjacencyList[V - 1].put(U - 1, adjacencyList[V - 1].get(U - 1) + 1);
                }
            }

            printTotalEdges(adjacencyList);
        }
    }

    private static void printTotalEdges(final Map<Integer, Integer>[] adjacencyList) {
        final int vertices = adjacencyList.length;

        final boolean[] visited = new boolean[vertices];
        int totalEdges = 0;
        for (int vertex = 0; vertex < vertices; vertex++) {
            if (!visited[vertex]) {
                int oddDegreeNodes = visit(vertex, adjacencyList, visited);
                totalEdges += Math.max(1, oddDegreeNodes / 2);
            }
        }

        System.out.println(totalEdges);
    }

    private static int visit(final int vertex1, final Map<Integer, Integer>[] adjacencyList, final boolean[] visited) {
        visited[vertex1] = true;
        int oddDegreeNodes = 0, vertexDegree = 0;

        for (final Map.Entry<Integer, Integer> vertex2 : adjacencyList[vertex1].entrySet()) {
            vertexDegree += vertex2.getValue();
            if (!visited[vertex2.getKey()]) {
                oddDegreeNodes += visit(vertex2.getKey(), adjacencyList, visited);
            }
        }

        return oddDegreeNodes + (vertexDegree % 2);
    }
}
