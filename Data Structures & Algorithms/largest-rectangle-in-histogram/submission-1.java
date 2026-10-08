class Solution {
    public int largestRectangleArea(int[] heights) {
      int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            // Treat the boundary after the last bar as height 0 to flush remaining elements from stack
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
                int height = heights[stack.pop()];
                
                // If stack is empty, it means 'height' was the smallest seen so far,
                // so it can expand all the way to index 0 (width = i).
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                
                maxArea = Math.max(maxArea, height * width);
            }
            
            stack.push(i);
        }

        return maxArea;
    }
   
}
