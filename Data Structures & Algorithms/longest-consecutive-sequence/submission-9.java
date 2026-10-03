class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int n= nums.length;
        int max=1;

        Set<Integer> set= new HashSet();
        for(int x: nums){
            set.add(x);
        }

        for(int x : set){
            if(!set.contains(x-1)){
                int len=0;
                while(set.contains(x+len)){
                    len++;
                }
                max = Math.max(len, max);
            }
        }
        return max;
    }
}
