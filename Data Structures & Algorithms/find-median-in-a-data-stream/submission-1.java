class MedianFinder {

    PriorityQueue<Integer> left = new PriorityQueue<>((a,b)->b-a), right = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());
        if(right.size()>left.size()) left.add(right.poll());
    }
    
    public double findMedian() {
        if(left.size()>right.size()) return (double)left.peek();
        return ((double)left.peek() + (double)right.peek())/2;
    }
}
