public class SSSPath {
    public static int minArray(int[] distance,boolean[] checked){
        int min=distance[0];
        int min_idx=0;
        for(int i=1;i<distance.length;i++){
            if(distance[i]<min){
                min=distance[i];
                min_idx=i;
            }
        }
        return min_idx;
    }

    public static void main(String[] args){
        int m=6;
        int[][] cost_matrix={{0,50,45,10,Integer.MAX_VALUE,Integer.MAX_VALUE},
                            {Integer.MAX_VALUE,0,10,15,Integer.MAX_VALUE,Integer.MAX_VALUE},
                            {Integer.MAX_VALUE,Integer.MAX_VALUE,0,Integer.MAX_VALUE,30,Integer.MAX_VALUE},
                            {20,Integer.MAX_VALUE,Integer.MAX_VALUE,0,15,Integer.MAX_VALUE},
                            {Integer.MAX_VALUE,20,35,Integer.MAX_VALUE,0,Integer.MAX_VALUE},
                            {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,3,0}};
        int iteration=1;
        int[] path=new int[m];
        path[0]=1;
        boolean[] checked=new boolean[m];
        checked[0]=true;
        int[] distance=new int[m];
        distance=cost_matrix[0];
        while(iteration<m){
            int min_idx=minArray(distance,checked);
            checked[min_idx]=true;
            for(int i=0;i<m && !checked[i] ;i++){
                if(distance[i]>distance[min_idx]+cost_matrix[min_idx][i]){
                    distance[i]=distance[min_idx]+cost_matrix[min_idx][i];
                }
            }
            iteration++;
        }
        for(int i=0;i<m;i++){
            System.out.print(distance[i]+" ");
        }
    }
}
