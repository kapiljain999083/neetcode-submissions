class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[n][m];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        return solve(m-1,n-1,dp);
    }

    int solve(int m, int n, int dp[][]){
        if(n==0 && m==0) return 1;
        if(n < 0 || m< 0) return 0;
        if(dp[n][m] != -1) return dp[n][m];
        int row = solve(m-1, n, dp);
        int col = solve(m, n-1, dp);
        return dp[n][m] = row+col;
    }
}
