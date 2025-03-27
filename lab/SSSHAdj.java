import java.util.*;

class Graph {
    private int V;
    private List<List<Node>> adj;

    // Node class to represent vertex and weight
    class Node {
        int vertex;
        int weight;
        
        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int w) {
        adj.get(u).add(new Node(v, w));
        // For undirected graph, add the reverse edge too:
        // adj.get(v).add(new Node(u, w));
    }

    void shortestPath(int src) {
        // Priority queue sorted by distance
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // Add source node to priority queue
        pq.add(new Node(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            // Extract the node with minimum distance
            Node currentNode = pq.poll();
            int u = currentNode.vertex;

            // Iterate through all adjacent vertices
            for (Node neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                // If shorter path is found
                if (dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        // Print the distances
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }
}

public class SSSHAdj {
    public static void main(String[] args) {
        int V = 7;
        Graph g = new Graph(V);

        g.addEdge(0, 1, 10);
        g.addEdge(0, 5, 30);
        g.addEdge(1, 2, 20);
        g.addEdge(2, 3, 15);
        g.addEdge(2, 4, 5);
        g.addEdge(3, 6, 20);
        g.addEdge(3, 4, 12);
        g.addEdge(4, 6, 7);
        g.addEdge(5, 6, 35);

        g.shortestPath(0);
    }
}