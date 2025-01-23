package Lists;
import java.util.*;
public class DepthFirstSearchDis{
    private static void dfsRec(List<List<Integer>> adj,boolean[] visited,int k){
        visited[k]=true;
        System.out.println(k+" ");
        for(int s:adj.get(k)){
            if(!visited[s]){
                dfsRec(adj,visited, s);
            }
        }
    }
    private static void dfs(List<List<Integer>> adj){
        boolean[] visited=new boolean[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(!visited[i]){
                dfsRec(adj, visited, i);
            }
        }
        
    }
    private static void addEdge(List<List<Integer>> adj,int m,int n){
        adj.get(m).add(n);
        adj.get(n).add(m);
    }
    public static void main(String args[]){
        int v=6;
        List<List<Integer>> adj=new ArrayList<>(v);
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        addEdge(adj,0,1);
        addEdge(adj,0,5);
        addEdge(adj,1,4);
        addEdge(adj,2,3);

        dfs(adj);
    }
}

