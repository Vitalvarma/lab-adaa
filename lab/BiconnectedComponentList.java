import java.util.*;

public class BiconnectedComponentsAdjList {
    private int V;
    private List<Integer>[] adj;
    private int time = 0;

    BiconnectedComponentsAdjList(int v) {
        V = v;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    void BCC() {
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] isAP = new boolean[V];
        Stack<int[]> stack = new Stack<>();

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                BCCUtil(i, disc, low, parent, stack, isAP);
            }
        }
    }

    void BCCUtil(int u, int[] disc, int[] low, int[] parent, Stack<int[]> stack, boolean[] isAP) {
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adj[u]) {
            if (disc[v] == -1) {
                children++;
                parent[v] = u;
                stack.push(new int[]{u, v});
                BCCUtil(v, disc, low, parent, stack, isAP);
                low[u] = Math.min(low[u], low[v]);

                if ((parent[u] == -1 && children > 1) || (parent[u] != -1 && low[v] >= disc[u])) {
                    isAP[u] = true;
                    System.out.print("Biconnected Component: ");
                    while (!stack.isEmpty() && !Arrays.equals(stack.peek(), new int[]{u, v})) {
                        int[] edge = stack.pop();
                        System.out.print("(" + edge[0] + "-" + edge[1] + ") ");
                    }
                    int[] edge = stack.pop();
                    System.out.println("(" + edge[0] + "-" + edge[1] + ")");
                }
            } else if (v != parent[u] && disc[v] < disc[u]) {
                stack.push(new int[]{u, v});
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public static void main(String[] args) {
        BiconnectedComponentsAdjList g = new BiconnectedComponentsAdjList(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.BCC();
    }
}
