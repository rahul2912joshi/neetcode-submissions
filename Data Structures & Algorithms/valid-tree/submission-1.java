class Solution {
    public boolean validTree(int n, int[][] edges) {
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        boolean value = hasCycle(adj, 0, visited,-1);
        if(value == true) return false;

        for(int i=0; i<visited.length; i++){
            if(visited[i]==false) return false;
        }
        return true;
    }
    public boolean hasCycle(ArrayList<List<Integer>> adj, int curr, boolean[] visited, int parent){
        visited[curr] = true;
        for(int neigh : adj.get(curr)){
            if(neigh == parent) continue;
            if(visited[neigh]==true) return true;
            if(hasCycle(adj,neigh,visited,curr)) return true;
        }
        return false;
    }
}
