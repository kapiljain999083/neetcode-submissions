class Solution {
    public int largestRectangleArea(int[] arr) {
        int ans = 0;
        int left[] = prevSmaller(arr); // get the indices from left smaller
        int right[] = nextSmaller(arr); // get the indices from right smaller
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int height = arr[i];
            int width = right[i] - left[i] - 1;
            ans = Math.max(ans, height * width);
        }
        return ans;
    }

    
    
    public int[] prevSmaller(int[] A) {
        int n = A.length;
        int result[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            if (!stack.empty() && A[stack.peek()] < A[i]) {
                result[i] = stack.peek();
            } else {
                result[i] = -1;
            }
            stack.push(i);
        }
        return result;
    }

    public int[] nextSmaller(int[] A) {
        int n = A.length;
        int result[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            if (!stack.empty() && A[stack.peek()] < A[i]) {
                result[i] = stack.peek();
            } else {
                result[i] = n;
            }
            stack.push(i);
        }
        return result;
    }
}
