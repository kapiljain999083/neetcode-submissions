class Solution {
    public int maxArea(int[] heights) {
        int max=0;
        int n=heights.length;
        int i=0;
        int j= n-1;
        while(i <= j){
            int h = Math.min(heights[i], heights[j]);
            int w = j-i;
            max = Math.max(h*w, max);
            if(h== heights[i]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}
