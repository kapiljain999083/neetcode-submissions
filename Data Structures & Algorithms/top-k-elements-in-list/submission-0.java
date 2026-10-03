class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        Comparator<Task> cmp = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.val - o2.val;
            }
        };
        PriorityQueue<Task> pq = new PriorityQueue<>(cmp);
        for (Map.Entry<Integer, Integer> m : map.entrySet()){
            pq.add(new Task(m.getKey(), m.getValue()));
            if(pq.size()>k) pq.remove();
        }
        int i=0;
        while (!pq.isEmpty()){
            ans[i++] = pq.remove().key;
        }
        return ans;
    }
}


class Task {

    int key;
    int val;

    public Task(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
