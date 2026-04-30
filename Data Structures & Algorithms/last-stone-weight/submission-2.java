class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b)->b-a);
        for(int i=0; i<stones.length; i++){
            maxheap.add(stones[i]);
        }
        while(maxheap.size()>1){
            int first = maxheap.poll();
            int second = maxheap.poll();
            if(first==second) continue;
            maxheap.add(Math.abs(first-second));
        }
        if(maxheap.size()==0) return 0;
        return maxheap.poll();
    }
}
