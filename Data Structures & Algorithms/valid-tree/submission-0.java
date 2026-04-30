class Solution {
    public boolean validTree(int n, int[][] edges) {
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u= edge[0], v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        if(!dfs(adj,visited,0,-1)) return false;
        for(int i=0; i<n; i++){
            if(!visited[i]) return false;
        }
        return true;
    }
    public boolean dfs(ArrayList<List<Integer>> adj, boolean[] visited, int source, int parent){
        visited[source] = true;
        //if(visited[source]) return false;
        for(int neighbour : adj.get(source)){
            if(!visited[neighbour]){
                if(!dfs(adj,visited,neighbour,source)){
                    return false;
                }
            } else if(neighbour != parent){
                return false;
            }
        }
        return true;
    }
}
