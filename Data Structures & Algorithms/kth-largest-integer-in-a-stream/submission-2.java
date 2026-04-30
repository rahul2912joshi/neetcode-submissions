class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        
        for(int i=0; i<nums.length; i++){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(pq.size() < k){
            pq.add(val);
        } else{
            if(val >= pq.peek()){
            pq.poll();
            pq.add(val);
        }
        }
        return pq.peek();
    }
}

// 1 2 3 3 3 5 6 7 8
