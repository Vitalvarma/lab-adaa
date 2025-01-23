package Lists;
import java.util.*;

class BreadthFirstSearch{
    private static void bfs(List<List<Integer>> adj,int k){
        boolean[] visited=new boolean[adj.size()];
        visited[k]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(k);
        while(!q.isEmpty()){
            int node=q.poll();
            System.out.println(node+" ");
            for(int p:adj.get(node)){
                if(!visited[p]){
                    visited[p]=true;
                    q.add(p);
                }
            }
        }
    }
    private static void addEdge(List<List<Integer>> adj,int n,int m){
        adj.get(n).add(m);
        adj.get(m).add(n);
    }
    public static void main(String args[]){
        List<List<Integer>> adj =new ArrayList<>(5);
        for(int i=0;i<5;i++){
            adj.add(new ArrayList<>());
        }
        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,3);
        addEdge(adj,2,4);

        bfs(adj,1);
    }

}