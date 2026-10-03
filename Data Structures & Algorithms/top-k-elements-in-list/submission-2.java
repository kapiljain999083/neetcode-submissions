class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for(int x: nums){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        Comparator<Info> cmp = new Comparator<Info>(){
            @Override
            public int compare(Info i1, Info i2){
                return i1.val - i2.val;
            }
        };
        PriorityQueue<Info> pq = new PriorityQueue(cmp);

        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            pq.add(new Info(m.getKey(), m.getValue()));
            if(pq.size()> k) pq.remove();
        }

        int arr[] = new int[pq.size()];
        int count =0;
        while(!pq.isEmpty()){
            arr[count++] = pq.remove().key;
        }
        return arr;
    }
}

class Info{
    int key;
    int val;

    public Info(int key, int val){
        this.key=key;
        this.val=val;
    }
}
