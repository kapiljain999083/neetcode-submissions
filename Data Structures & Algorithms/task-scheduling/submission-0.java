class Solution {
    public int leastInterval(char[] tasks, int n) {
       int time = 0;
        int count[] = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<int[]> queue = new LinkedList<>();
        for (char x : tasks) {
            count[x - 'A']++;
        }
        for (int x : count) {
            if (x > 0) {
                pq.add(x);
            }
        }
        while (!pq.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int remain = pq.remove() - 1;
                if (remain > 0) queue.add(new int[]{remain, time + n});
            }
            if (!queue.isEmpty() && queue.peek()[1] <= time) {
                pq.add(queue.remove()[0]);
            }
        }
        return time;
    }
}