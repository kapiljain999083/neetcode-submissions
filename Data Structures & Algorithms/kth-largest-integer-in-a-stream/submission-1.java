class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k; 
        for(int x : nums){
            if(pq.size()>k) pq.remove();
            pq.add(x);
        }
    }
    
    public int add(int val) {
        if(pq.size()>k) pq.remove();
        pq.add(val);        
        if(pq.size() > k)  pq.remove();
        return pq.peek();
    }
}
