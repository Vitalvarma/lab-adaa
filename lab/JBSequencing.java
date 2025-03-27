import java.util.Arrays;
import java.util.Comparator;

class JBSequencing {
    static boolean condition(int[] mark, int dead, int n) {
        for (int i = dead; i >= 1; i--) {
            if (i <= n && mark[i] == -1) {
                mark[i] = 1;
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int numJobs = 7; 
        int profit[] = new int[]{3, 5, 20, 18, 1, 6, 30}; 
        int dead[] = new int[]{1, 3, 4, 3, 2, 1, 2};
        int totalProfit = 0;
        int n = 4; 

        int[][] jobs = new int[numJobs][2];
        for (int i = 0; i < numJobs; i++) {
            jobs[i][0] = profit[i]; 
            jobs[i][1] = dead[i];   
        }

        Arrays.sort(jobs, new Comparator<int[]>() {
            public int compare(int[] job1, int[] job2) {
                return job2[0] - job1[0]; 
            }
        });

        int mark[] = new int[n + 1]; 
        Arrays.fill(mark, -1); 

        for (int i = 0; i < numJobs; i++) {
            int jobProfit = jobs[i][0]; 
            int jobDead = jobs[i][1];  

            if (condition(mark, jobDead, n)) {
                totalProfit += jobProfit; 
            }
        }

        // Output the total profit
        System.out.println("Total Profit: " + totalProfit);
    }
}