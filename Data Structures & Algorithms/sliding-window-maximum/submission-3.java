class Solution {
    public int[] maxSlidingWindow(int[] arr, int windowSize) {
        int n = arr.length;
        int ans[] = new int[(n - windowSize) + 1];
        int count = 0;
        for (int i = 0; i <= (n - windowSize); i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + windowSize; j++) {
                max = Math.max(max, arr[j]);
            }
            ans[count++] = max;
        }
        return ans;
    }
}
