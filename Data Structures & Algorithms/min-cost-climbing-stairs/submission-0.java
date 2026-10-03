class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n= cost.length;
        int ans[] = new int[n+1];
        Arrays.fill(ans, -1);
        return climb(n, cost, ans);
    }

    public int climb(int n, int cost[], int ans[]) {
        if(n <= 1) return 0;
        if(ans[n]!=-1) return ans[n];
        int one = cost[n-1] + climb(n-1, cost, ans);
        int two = cost[n-2] + climb(n-2, cost, ans);
        return ans[n] =  Math.min(one, two);
    }
}
