class Solution {
    public int maxProfit(int[] prices) {
        int buy =prices[0];
        int max = 0;
        for(int i : prices){
            buy = Math.min(buy, i);
            max = Math.max(max, i-buy);
        }
        return max;
    }
}
