class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0; 
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        int res = r;
        while (l <= r) {
            int k = (r + l) / 2;

            long totalHours = 0;
            for (int pile : piles) {
                totalHours += (pile + k - 1) / k;
            }
            if (totalHours <= h) {
                res = k;   
                r = k - 1; 
            } else {
                l = k + 1; 
            }
        }
        return res;
    }
}
