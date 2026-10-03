class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        Arrays.sort(nums);
        int n= nums.length;
        int count=1;
        int max=count;
        int prev = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]==prev){
                continue;
            }
            if(nums[i]==prev+1){
                count++;
            }else if(nums[i] > prev+1){
                count=1;
            }
            max = Math.max(max, count);
            prev = nums[i];
        }
        return max;
    }
}
