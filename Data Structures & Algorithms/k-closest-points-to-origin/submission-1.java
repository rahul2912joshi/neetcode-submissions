class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0; i<points.length; i++){
            int dist = points[i][1]*points[i][1]+points[i][0]*points[i][0];
            if(maxheap.size()<k){
                maxheap.add(new int[]{dist,i});
            } else{
                if(maxheap.peek()[0] > dist){
                    maxheap.poll();
                    maxheap.add(new int[]{dist,i});
                }
            }
        }
        int[][] result = new int[k][2];
        for(int i=0; i<k; i++){
            int pos = maxheap.poll()[1];
            result[i] = points[pos];
        }
        return result;
    }
}
