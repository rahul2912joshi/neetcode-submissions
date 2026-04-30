class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            if(minheap.size()<k){
                minheap.offer(nums[i]);
            } else{
                if(nums[i]>minheap.peek()){
                    minheap.remove();
                    minheap.add(nums[i]);
                }
            }
        }
        return minheap.peek();
    }
}
