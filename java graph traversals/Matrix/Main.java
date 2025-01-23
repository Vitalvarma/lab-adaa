package Matrix;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Graph {
    public void printDFS(int[][] adj_mat) {
        int v = adj_mat.length;
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                DFSHelper(adj_mat, visited, i);
            }
        }
    }

    private void DFSHelper(int[][] adj_mat, boolean[] visited, int sv) {
        System.out.println(sv);
        visited[sv] = true;
        int v = adj_mat.length;

        for (int i = 0; i < v; i++) {
            if (adj_mat[sv][i] == 1 && !visited[i]) {
                DFSHelper(adj_mat, visited, i);
            }
        }
    }

    public void printBFS(int[][] adj_mat) {
        int v = adj_mat.length;
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                BFSHelper(adj_mat, visited, i);
            }
        }
    }

    private void BFSHelper(int[][] adj_mat, boolean[] visited, int sv) {
        Queue<Integer> queue = new LinkedList<>();
        visited[sv] = true;
        int v = adj_mat.length;
        queue.offer(sv);
        
        while (!queue.isEmpty()) {
            int polled = queue.poll();
            System.out.println(polled);
            for (int i = 0; i < v; i++) {
                if (adj_mat[polled][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}

public class Main {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int v = sc.nextInt();
        System.out.println("Enter number of edges:");
        int e = sc.nextInt();

        // Initialize adjacency matrix
        int[][] adj_mat = new int[v][v];

        System.out.println("Enter edges (format: start_vertex end_vertex):");
        for (int i = 0; i < e; i++) {
            int sv = sc.nextInt();
            int ev = sc.nextInt();
            // Input validation
            if (sv >= 0 && sv < v && ev >= 0 && ev < v) {
                adj_mat[sv][ev] = 1;
                adj_mat[ev][sv] = 1; // For undirected graph
            } else {
                System.out.println("Invalid edge: " + sv + " " + ev);
            }
        }

        Graph graph = new Graph();
        System.out.println("========== Printing DFS ==========");
        graph.printDFS(adj_mat);

        System.out.println("========== Printing BFS ==========");
        graph.printBFS(adj_mat);

        sc.close(); // Close the scanner
    }
}