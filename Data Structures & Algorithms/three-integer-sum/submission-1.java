class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) right--;
                else if (sum < 0) left++;
                else {
                    if(!ans.contains(List.of(nums[i], nums[left], nums[right]))){
                        ans.add(List.of(nums[i], nums[left], nums[right]));
                    }
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }
}
