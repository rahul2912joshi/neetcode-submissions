class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        int[] result = new int[k];
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            int[] value = new int[]{entry.getValue(),entry.getKey()};
            if(pq.size() < k){
                pq.add(value);
            } else{
                if(value[0] > pq.peek()[0]){
                    pq.poll();
                    pq.add(value);
                }
            }
        }
        for(int i=0; i<k;i++){
            result[i] = pq.poll()[1];
        }
        return result;
    }
}
