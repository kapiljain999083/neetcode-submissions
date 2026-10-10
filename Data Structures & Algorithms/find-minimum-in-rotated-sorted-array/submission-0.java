class Solution {
    public int findMin(int[] nums) {
        int ans = nums[0];
        int left =0, right=  nums.length-1;

        while(left <=  right){
            int mid = (left+right)/2;

            if(nums[left] < nums[right]){
                ans =  Math.min(ans, nums[left]);
                return ans;
            }

            ans = Math.min(nums[mid], ans);
            if(nums[left] <= nums[mid]){
                left = mid+1;
            }else{
                right=mid-1;
            }
            
        }

        return ans;
    }
}
