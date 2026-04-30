class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<int[]>());
        }
        for(int i=0; i<times.length; i++){
            int u=times[i][0];
            int v=times[i][1];
            int time = times[i][2];
            adj.get(u).add(new int[]{v,time});
        }
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        minheap.add(new int[]{k,0});
        dist[k] = 0;
        while(!minheap.isEmpty()){
            int[] curr = minheap.poll();
            int node = curr[0];
            int weight = curr[1];
            for(int[] neigh : adj.get(node)){
                int next = neigh[0];
                int time = neigh[1];
                if(time+weight < dist[next]){
                    dist[next] = weight+time;
                    minheap.add(new int[]{next,dist[next]});
                }
            }
        }
        int max=0;
        for(int i=1; i<=n ; i++){
            if(i!=0 && dist[i]==Integer.MAX_VALUE) return -1;
            if(max<dist[i]) max=dist[i];
        }
        return max;
    }
}
// inf inf inf inf
// 0 1 inf 4
// 0 1 2 4
// 0 1 2 3
// if any inf return -1
// return max value in dist array

// 1 -> {2,4} 3 4