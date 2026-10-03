class MedianFinder {

    List<Integer> list;
    double median;
    public MedianFinder() {
        list= new ArrayList();
        median = 0d;
    }
    
    public void addNum(int num) {
        list.add(num);     
        Collections.sort(list);   
    }
    
    public double findMedian() {
        int size = list.size();
        if(size == 1) return list.get(0);
        int mid = size/2;
        if(size % 2 != 0){
            return list.get(mid);
        }
        return (Double.valueOf(list.get(mid)) + Double.valueOf(list.get(mid-1))) / 2;
    }
}
