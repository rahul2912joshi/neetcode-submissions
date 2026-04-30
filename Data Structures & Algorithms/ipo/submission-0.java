class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b) -> b[1]-a[1]);

        for(int i=0; i< profits.length; i++){
            minheap.add(new int[]{capital[i],profits[i]});
        }

        for(int i=0; i<k; i++){
            while(minheap.isEmpty()==false && minheap.peek()[0] <= w){
                maxheap.add(minheap.poll());
            }

            if(maxheap.isEmpty()) break;

            w += maxheap.poll()[1];
        }
        return w;
    }
}
// minheap -> least capital with profit
// maxheap -> capital < w all
// update maxheap and return when empty