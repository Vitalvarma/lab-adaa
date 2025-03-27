
import java.util.*;

public class BiconnectedComponentMat{
    private int V; // Number of vertices
    private int[][] adjMatrix;
    private int time;
    
    public BiconnectedComponentMat(int vertices) {
        this.V = vertices;
        this.adjMatrix = new int[V][V];
        this.time = 0;
    }
    
    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }
    
    // A recursive function that finds and prints biconnected components using DFS
    private void bccUtil(int u, int[] disc, int[] low, LinkedList<Integer> stack, int[] parent) {
        disc[u] = low[u] = ++time;
        int children = 0;
        
        // Push current vertex to stack
        stack.push(u);
        
        // Go through all vertices adjacent to this vertex
        for (int v = 0; v < V; v++) {
            if (adjMatrix[u][v] == 1) { // If v is adjacent to u
                if (disc[v] == -1) { // If v is not visited yet
                    children++;
                    parent[v] = u;
                    
                    // Recur for v
                    bccUtil(v, disc, low, stack, parent);
                    
                    // Check if the subtree rooted with v has a connection to
                    // one of the ancestors of u
                    low[u] = Math.min(low[u], low[v]);
                    
                    // If u is an articulation point, then pop all edges from stack till u-v
                    if ((parent[u] == -1 && children > 1) || (parent[u] != -1 && low[v] >= disc[u])) {
                        System.out.print("Biconnected component: ");
                        while (stack.peek() != u) {
                            System.out.print(stack.pop() + " ");
                        }
                        System.out.println(stack.pop() + " " + u);
                    }
                } else if (v != parent[u]) { // Update low value of u for parent function calls
                    low[u] = Math.min(low[u], disc[v]);
                }
            }
        }
    }
    
    // The main function that finds and prints all biconnected components
    public void findBiconnectedComponents() {
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        LinkedList<Integer> stack = new LinkedList<>();
        
        // Initialize disc and parent arrays
        Arrays.fill(disc, -1);
        Arrays.fill(parent, -1);
        
        // Call the recursive helper function to find articulation points
        // in DFS tree rooted with vertex 'i'
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                bccUtil(i, disc, low, stack, parent);
            }
            
            // If stack is not empty, pop all edges from stack
            if (!stack.isEmpty()) {
                System.out.print("Biconnected component: ");
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop() + " ");
                }
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        // Create a graph
        BiconnectedComponentMat g = new BiconnectedComponentMat(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        
        System.out.println("Biconnected components in the graph:");
        g.findBiconnectedComponents();
    }
}
