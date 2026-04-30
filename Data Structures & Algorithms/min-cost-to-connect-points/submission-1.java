class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        minheap.offer(new int[]{0,0});
        int edges = n;
        int edgesused = 0, result=0;
        boolean[] visited = new boolean[n];
        while(edgesused<n){
            int curr[] = minheap.poll();
            int dist = curr[0];
            int index = curr[1];
            if(visited[index]==true) continue;

            visited[index] = true;
            result+=dist;
            edgesused++;
            for(int v=0; v<n; v++){
                if(!visited[v]){
                    int cost = Math.abs(points[index][0]-points[v][0]) + Math.abs(points[index][1]-points[v][1]);
                    minheap.offer(new int[]{cost,v});
                }
            }
        }
        return result;
    }
}
