
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         int ans = 0;
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        for (int x : piles) {
            max = Math.max(max, x);
        }
        int left = 1;
        while (left <= max) {
            int mid = (left + max) / 2;
            java.math.BigDecimal currTime = java.math.BigDecimal.ZERO;
            for (int i = 0; i < n; i++) {
                currTime = currTime.add(java.math.BigDecimal.valueOf(piles[i]).divide(java.math.BigDecimal.valueOf(mid), java.math.RoundingMode.CEILING));
            }
            if (currTime.intValue() <= h) {
                ans = mid;
                max = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
