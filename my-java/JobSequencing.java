import java.util.Arrays;

class JobSequencing {
    static boolean condition(int[] mark, int dead, int n) {
        // Check from the job's deadline down to 1 for an available slot
        for (int i = dead; i >= 1; i--) { 
            if (i <= n && mark[i] == -1) { 
                mark[i] = 1; // Mark this slot as filled
                return true; 
            }
        }
        return false; 
    }

    static void swap(int l, int k, int[] profit, int[] dead) {
        // Swap profits
        int temp = profit[l];
        profit[l] = profit[k];
        profit[k] = temp;

        // Swap deadlines
        temp = dead[l];
        dead[l] = dead[k];
        dead[k] = temp;
    }

    static void sortProfitDead(int profit[], int dead[], int m) {
        // Simple bubble sort to sort profits and deadlines in descending order of profit
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                if (profit[j-1] < profit[j]) {
                    swap(j-1, j, profit, dead);
                }
            }
        }
    }

    public static void main(String args[]) {
        int numJobs = 7; // Number of jobs
        int profit[] = new int[]{3, 5, 20, 18, 1, 6, 30}; 
        int dead[] = new int[]{1, 3, 4, 3, 2, 1, 2};
        int totalProfit = 0;
        int n = 4; // Maximum deadline
        sortProfitDead(profit, dead, numJobs);

        int mark[] = new int[n + 1]; // Mark array size should be n + 1
        Arrays.fill(mark, -1); // Initialize with -1 (indicating all slots are empty)

        for (int i = 0; i < numJobs; i++) {
            // If the current job can be scheduled, add its profit
            if (condition(mark, dead[i], n)) { 
                totalProfit += profit[i]; 
                System.out.println(totalProfit);
            }
        }

        System.out.println("Total Profit: " + totalProfit);
    }
}
