class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        // 1 3, 2 2, 3 1

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[1]-b[1]));

        for(int i : freq.keySet()){
            if(minHeap.size()<k){
                minHeap.offer(new int[]{i,freq.get(i)});
                continue;
            }
            if(freq.get(i) > minHeap.peek()[1]){
                minHeap.poll();
                minHeap.offer(new int[]{i,freq.get(i)});
            }
        }

        int[] result = new int[k];
        for(int i=0; i<k; i++){
            int[] val = minHeap.poll();
            result[i] = val[0];
        }

        return result;
    }
}


