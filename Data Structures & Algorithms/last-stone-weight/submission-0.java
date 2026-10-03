class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        for(int x : stones){
            pq.add(x);
        }

        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();
            pq.add(Math.abs(first-second));
        }

        return pq.poll();
    }
}
