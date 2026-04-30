class MedianFinder {
    PriorityQueue<Integer> maxQueue;
    PriorityQueue<Integer> minQueue;

    public MedianFinder() {
        maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        minQueue = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxQueue.add(num);
        minQueue.add(maxQueue.poll());
        if(minQueue.size() > maxQueue.size()){
            maxQueue.add(minQueue.poll());
        }
        // if(maxQueue.size() == minQueue.size()){
        //     if(num <= maxQueue.peek()){
        //         maxQueue.add(num);
        //     } else{
        //         maxQueue.add(minQueue.poll());
        //         minQueue.add(num);
        //     }
        // } else{
        //     if(num > maxQueue.peek()){
        //         minQueue.add(num);
        //     } else{
        //         minQueue.add(maxQueue.poll());
        //         maxQueue.add(num);
        //     }
        // }
    }
    
    public double findMedian() {
        if(maxQueue.size() > minQueue.size()){
            return maxQueue.peek();
        } else{
            return (maxQueue.peek() + minQueue.peek()) / 2.0;
        }
    }
}
