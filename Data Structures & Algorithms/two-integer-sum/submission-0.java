class Solution {
    public int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        Map<Integer,Integer> map = new HashMap();

        for(int i=0;i<nums.length;i++){
            if(map.get(target - nums[i]) != null){
                arr[1] = i;
                arr[0] = map.get(target - nums[i]);
            }
            map.put(nums[i],i);
        }
        return arr;

    }
}
