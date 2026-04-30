class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b)->b[2]-a[2]);
        ArrayList<int[]> result = new ArrayList<>();
        for(int i=0; i<points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = x*x + y*y;
            if(maxheap.size()<k){
                maxheap.offer(new int[]{x,y,dist});
            } else{
                if(maxheap.peek()[2] > dist){
                    maxheap.poll();
                    maxheap.offer(new int[]{x,y,dist});
                }
            }
        }
        while(!maxheap.isEmpty()){
            int[] vals = maxheap.poll();
            result.add(new int[]{vals[0],vals[1]});
        }
        return result.toArray(new int[result.size()][]);
    }
}
