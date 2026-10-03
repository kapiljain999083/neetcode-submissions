class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> set = new HashMap();
        int arr [] = new int [2];
        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            if(set.get(target-x) != null){
              arr[0]  = set.get(target-x);
              arr[1]  = i;
              return arr;
            }
            set.put(x,i);
        }
        return arr;
    }
}
