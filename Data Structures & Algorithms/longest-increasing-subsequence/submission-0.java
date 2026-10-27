class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length];
        for(int [] x : dp) Arrays.fill(x, -1);
        return solve(0, -1, nums, dp);
    }

    public int solve(int curr, int prev, int nums[], int dp[][]){
        if(curr == nums.length) return 0;
        if(dp[curr][prev+1] != -1) return dp[curr][prev+1];
        int notTake = solve(curr+1, prev, nums, dp);
        int take =0;
        if(prev == -1 || nums[curr] > nums[prev]){
            take = 1 + solve(curr+1, curr, nums, dp);
        }
        return dp[curr][prev+1] = Math.max(take, notTake);
    }
}

