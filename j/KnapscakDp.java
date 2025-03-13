

class knapsackRecur{

    static int knapsackRec(int W, int[] val, int[] wt, int n,int[][] dp) {

        if (n == 0 || W == 0)
            return 0;

        if (dp[n][W] != -1){
            return dp[n][W];
        }

        int pick = 0;

        if (wt[n - 1] <= W)
            pick = val[n - 1] + knapsackRec(W - wt[n - 1], val, wt, n - 1,dp);
        
        int notPick = knapsackRec(W, val, wt, n - 1,dp);
         
        return dp[n][W]=Math.max(pick, notPick);
    }

    static int knapsack(int W, int[] val, int[] wt) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++)
                dp[i][j] = -1;
        }
        return knapsackRec(W, val, wt, n,dp);
    }
    
    public static void main(String[] args) {
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        int W = 4;

        System.out.println(knapsack(W, val, wt));
    }
}