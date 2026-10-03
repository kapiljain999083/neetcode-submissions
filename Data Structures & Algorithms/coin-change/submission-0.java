class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int arr[]: dp){
            Arrays.fill(arr, -2);
        }
        return solve(n-1, amount, coins, dp);
    }

    public int solve(int n, int amount, int coins[], int dp[][]){
        if(amount == 0) return 0;
        if(n < 0 || amount < 0) return -1;
        if(dp[n][amount] != -2) return dp[n][amount];
        
        int notTake = solve(n-1, amount, coins, dp);
        int take = -1;
        if(amount >= coins[n]){
            take = solve(n, amount - coins[n], coins, dp);
            if (take != -1) take = 1 + take;
        }

        if (take == -1) dp[n][amount] = notTake;
        else if (notTake == -1) dp[n][amount] = take;
        else dp[n][amount] = Math.min(take, notTake);
        
        return dp[n][amount];
    }
}