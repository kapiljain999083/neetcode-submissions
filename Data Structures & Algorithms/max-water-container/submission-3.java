class Solution {
    public int maxArea(int[] heights) {
        int ans=0;
        int left=0, right= heights.length-1;
        while(left <= right){
            int height = Math.min(heights[left], heights[right]);
            int width = right-left;
            ans = Math.max(height * width, ans);
            if(height == heights[left]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}
