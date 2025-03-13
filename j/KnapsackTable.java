

class knapsackTable{

    static int knapsackTab(int W, int[] val, int[] wt,int n) {
        int[][] dp=new int[n+1][W+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<W+1;i++){
            dp[0][i]=0;
        }
        int pick;
        int notPick;
        for(int i=0;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                pick=0;
                if(wt[i-1]<=W){
                    pick=val[i-1]+dp[i-1][j-wt[n-1]];
                }
                notPick=dp[i-1][j];
                dp[i][j]=Math.max(pick,notPick);
            }
        }
        return dp[n][W];
    }

    static int knapsack(int W, int[] val, int[] wt) {
        int n = val.length;
        return knapsackTab(W, val, wt, n);
    }
    
    public static void main(String[] args) {
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        int W = 4;

        System.out.println(knapsack(W, val, wt));
    }
}