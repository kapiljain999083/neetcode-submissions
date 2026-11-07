class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x:  nums){
            sum += x;
        }
        if(sum%2 ==1) return false;
        int target = sum/2;
        Boolean dp[][] = new Boolean[n][target +1];
        return solve(nums, n-1, target, dp);
    }

    boolean solve(int nums[], int n, int target, Boolean dp[][]){
        if(target==0) return true;
        if(n==0) return target == nums[0];
        if(dp[n][target] != null) return dp[n][target];
        boolean take = false;
        boolean notTake = solve(nums, n-1, target, dp);
        if(target >= nums[n]){
            take = solve(nums, n-1, target-nums[n], dp);
        }
        return dp[n][target] = take || notTake;
    }
}
