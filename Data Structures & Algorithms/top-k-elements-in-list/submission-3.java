class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        int[] result = new int[k];
        for(int i=0; i<nums.length; i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            if(minheap.size()<k){
                minheap.add(new int[]{entry.getKey(),entry.getValue()});
            } else{
                if(minheap.peek()[1] < entry.getValue()){
                    minheap.poll();
                    minheap.add(new int[]{entry.getKey(),entry.getValue()});
                }
            }
        }
        int i=0;
        while(minheap.isEmpty()==false){
            result[i]=minheap.poll()[0];
            i++;
        }
        return result;
    }
}
