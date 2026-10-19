class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;    
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return climb(n, cost, dp);
    }

    int climb(int n, int cost[], int dp[]){
        if(n<=1) return 0;
        if(dp[n] != -1) return dp[n];
        int one = cost[n-1] + climb(n-1, cost, dp);
        int two = cost[n-2] + climb(n-2, cost, dp);
        return dp[n] =  Math.min(one, two);
    }
}