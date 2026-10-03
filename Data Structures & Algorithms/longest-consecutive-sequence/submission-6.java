class Solution {
    public int longestConsecutive(int[] nums) {
       if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 1;
        int maxCount = count;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev == nums[i]) {
                continue;
            }
            if (nums[i] > prev + 1) {
                count = 1;
            } else if (nums[i] == prev + 1){
                count++;
            }
            prev = nums[i];
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
