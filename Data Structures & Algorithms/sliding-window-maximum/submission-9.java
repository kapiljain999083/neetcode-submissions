public class Solution {
  
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Element> maxHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(new Element(nums[i], i));

            while (maxHeap.peek().index <= i - k) {
                maxHeap.poll();
            }

            // Record maximum once full window size is reached
            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek().val;
            }
        }

        return result;
    }
}

 class Element implements Comparable<Element> {
        final int val;
        final int index;

        Element(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Element other) {
            return Integer.compare(other.val, this.val);
        }
    }