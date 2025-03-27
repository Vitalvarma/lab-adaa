import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BFSGraph {

    // Breadth-First Search (BFS) Traversal
    public void printBFS(int[][] adjMatrix) {
        int numVertices = adjMatrix.length;
        boolean[] visited = new boolean[numVertices];

        System.out.print("BFS Traversal: ");
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                BFSHelper(adjMatrix, visited, i);
            }
        }
        System.out.println();
    }

    private void BFSHelper(int[][] adjMatrix, boolean[] visited, int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[currentVertex][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of vertices
        System.out.print("Enter the number of vertices: ");
        int numVertices = sc.nextInt();

        // Input: Number of edges
        System.out.print("Enter the number of edges: ");
        int numEdges = sc.nextInt();

        // Initialize adjacency matrix
        int[][] adjMatrix = new int[numVertices][numVertices];

        System.out.println("Enter edges (format: start_vertex end_vertex):");
        for (int i = 0; i < numEdges; i++) {
            int startVertex = sc.nextInt();
            int endVertex = sc.nextInt();

            // Input validation
            if (startVertex < 0 || startVertex >= numVertices || endVertex < 0 || endVertex >= numVertices) {
                System.out.println("Invalid edge: " + startVertex + " " + endVertex);
                i--; // Retry input
                continue;
            }

            adjMatrix[startVertex][endVertex] = 1;
            adjMatrix[endVertex][startVertex] = 1; // For an undirected graph
        }

        BFSGraph graph = new BFSGraph();
        System.out.println("\n========== BFS Traversal ==========");
        graph.printBFS(adjMatrix);

        sc.close();
    }
}
