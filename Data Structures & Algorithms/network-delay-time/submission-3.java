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
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        dist[k] = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int[] neigh : adj.get(curr)){
                int next = neigh[0];
                int time = neigh[1];
                if(dist[curr]+time < dist[next]){
                    dist[next] = dist[curr]+time;
                    q.add(next);
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