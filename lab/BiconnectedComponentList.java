import java.util.*;

public class BiconnectedComponentList {
    private int V;
    private ArrayList<Integer>[] adj;
    private int time;
    private int componentCount;

    class Edge {
        int u, v;
        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
        
        @Override
        public String toString() {
            return u + "-" + v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return (u == edge.u && v == edge.v) || (u == edge.v && v == edge.u);
        }

        @Override
        public int hashCode() {
            return Objects.hash(u, v) + Objects.hash(v, u);
        }
    }

    @SuppressWarnings("unchecked")
    public BiconnectedComponentList(int vertices) {
        this.V = vertices;
        this.adj = new ArrayList[V];
        ArrayList<Integer>[] temp = (ArrayList<Integer>[]) new ArrayList[V];
        this.adj = temp;
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        this.time = 0;
        this.componentCount = 0;
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public void findBCCs() {
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        Deque<Edge> stack = new ArrayDeque<>();

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        System.out.println("Biconnected Components:");
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                bccUtil(i, disc, low, stack, parent);
                
                // Process remaining edges in stack after DFS
                boolean firstEdge = true;
                while (!stack.isEmpty()) {
                    if (firstEdge) {
                        System.out.print("Component " + (++componentCount) + ": ");
                        firstEdge = false;
                    }
                    System.out.print(stack.pop() + " ");
                }
                if (!firstEdge) {
                    System.out.println();
                }
            }
        }
        System.out.println("Total biconnected components: " + componentCount);
    }

    private void bccUtil(int u, int[] disc, int[] low, Deque<Edge> stack, int[] parent) {
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adj[u]) {
            if (disc[v] == -1) {
                children++;
                parent[v] = u;
                stack.push(new Edge(u, v));
                bccUtil(v, disc, low, stack, parent);

                low[u] = Math.min(low[u], low[v]);

                // Check for articulation point
                if ((parent[u] == -1 && children > 1) || (parent[u] != -1 && low[v] >= disc[u])) {
                    System.out.print("Component " + (++componentCount) + ": ");
                    Edge current = new Edge(u, v);
                    while (!stack.peek().equals(current)) {
                        System.out.print(stack.pop() + " ");
                    }
                    System.out.println(stack.pop());
                }
            } else if (v != parent[u] && disc[v] < disc[u]) {
                stack.push(new Edge(u, v));
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public static void main(String[] args) {
        BiconnectedComponentList g = new BiconnectedComponentList(12);
        
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(1, 5);
        g.addEdge(0, 6);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(5, 8);
        g.addEdge(7, 8);
        g.addEdge(8, 9);
        g.addEdge(10, 11);

        g.findBCCs();
    }
}