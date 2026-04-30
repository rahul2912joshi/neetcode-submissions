class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=edges.length;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            HashSet<Integer> visited = new HashSet<>();

            if(hasPath(adj, u, v, visited)){
                return new int[]{u,v};
            }

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[]{0,0};
    }
    public boolean hasPath(ArrayList<List<Integer>> adj, int u, int v, HashSet<Integer> visited){
        if(u==v) return true;
        visited.add(u);

        for(int neigh : adj.get(u)){
            if(!visited.contains(neigh)){
                if(hasPath(adj,neigh,v,visited)) return true;
            }
        }
        return false;
    }
}
