class Solution {
    public int trap(int[] A) {
        int n = A.length;
        int leftMaxArr[] = new int[n];
        int rightMaxArr[] = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, A[i]);
            leftMaxArr[i] = max;
        }

        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, A[i]);
            rightMaxArr[i] = max;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(rightMaxArr[i], leftMaxArr[i]) - A[i];
        }
        return ans;
        
    }
}
