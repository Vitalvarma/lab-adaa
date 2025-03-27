import java.util.Scanner;
import java.util.Stack;

class DFSGraph {

    // Depth-First Search (DFS) Traversal using Stack
    public void printDFS(int[][] adjMatrix) {
        int numVertices = adjMatrix.length;
        boolean[] visited = new boolean[numVertices];

        System.out.print("DFS Traversal: ");
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                DFSHelper(adjMatrix, visited, i);
            }
        }
        System.out.println();
    }

    private void DFSHelper(int[][] adjMatrix, boolean[] visited, int startVertex) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);
        
        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            System.out.print(currentVertex + " ");
            visited[currentVertex] = true;
                
            // Push adjacent vertices in reverse order to maintain same order as recursive DFS
            for (int i = adjMatrix.length - 1; i >= 0; i--) {
                if (adjMatrix[currentVertex][i] == 1 && !visited[i]) {
                    stack.push(i);
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

        DFSGraph graph = new DFSGraph();
        System.out.println("\n========== DFS Traversal (Stack) ==========");
        graph.printDFS(adjMatrix);

        sc.close();
    }
}