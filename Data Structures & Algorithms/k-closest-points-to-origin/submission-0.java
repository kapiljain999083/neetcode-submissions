class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<Task> cmp = new Comparator<>() {
            @Override
            public int compare(Task t1, Task t2) {
                if (t1.val > t2.val) return -1;
                if (t2.val > t1.val) return 1;
                return 0;
            }
        };
        PriorityQueue<Task> pq = new PriorityQueue(cmp);
        for (int i = 0; i < points.length; i++) {
            int arr[] = points[i];
            int val = (arr[0] * arr[0]) + (arr[1] * arr[1]);
            pq.add(new Task(arr, val));
            if (pq.size() > k) pq.remove();
        }
        int ans[][] = new int[pq.size()][2];
        int count=0;
        while(!pq.isEmpty()){
            ans[count] = pq.remove().arr;
            count++;
        }
        return ans;
    }
}

class Task{

    int arr[];
    int val;

    public Task(int arr[], int val){
        this.val=val;
        this.arr=arr;
    }
}