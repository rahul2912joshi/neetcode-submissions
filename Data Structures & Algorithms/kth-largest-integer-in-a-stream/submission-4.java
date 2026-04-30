class KthLargest {

    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        int i=0;
        while(i<nums.length && pq.size()<k){
            pq.add(nums[i]);
            i++;
        }
        while(i<nums.length){
            if(nums[i] > pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
            i++;
        }
    }
    
    public int add(int val) {
        if(pq.size() < k){
            pq.add(val);
            return pq.peek();
        }
        if(val > pq.peek()){
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}
