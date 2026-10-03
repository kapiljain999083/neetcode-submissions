class Solution {
    public boolean canJump(int[] arr) {
        int n = arr.length;
        int max =0;
        for (int i = 0; i < n; i++) {
            if(max < i) return false;
            if(max >= n-1) return true;
            max = Math.max(max, i + arr[i]);        }
        return true;
    }
}
