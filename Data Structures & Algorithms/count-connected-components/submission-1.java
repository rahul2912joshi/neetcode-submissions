class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int u= edges[i][0];
            int v= edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int count  = 0;
        for(int i=0; i<n ; i++){
            if(visited[i]==false){
                dfs(adj,i,visited);
                count++;
            }
        }
        return count;
    }
    public void dfs(ArrayList<List<Integer>> adj, int source, boolean[] visited){
        visited[source]=true;
        for(int neigh : adj.get(source)){
            if(visited[neigh]==false){
                dfs(adj,neigh,visited);
            }
        }
    }
}
