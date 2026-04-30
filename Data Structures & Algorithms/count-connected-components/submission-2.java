class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(graph,i,visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(List<List<Integer>> graph, int i, boolean[] visited){
        if(visited[i]){
            return;
        }

        visited[i] = true;

        for(int neigh : graph.get(i)){
            dfs(graph, neigh, visited);
        }
        return;
    }
}
