class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0; 
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        int res = r;
        while (l <= r) {
            int mid = (r + l) / 2;

            long totalHours = 0;
            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid;
            }
            if (totalHours <= h) {
                res = mid;   
                r = mid - 1; 
            } else {
                l = mid + 1; 
            }
        }
        return res;
    }
}
