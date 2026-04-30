class Solution {
    public int countComponents(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        for(int[] edge : edges){
            int u=edge[0], v=edge[1];
            graph[u][v]=1;
            graph[v][u]=1;
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(graph, visited, i);
                count++;
            }
        }
        return count;
    }
    public void dfs(int[][] graph, boolean[] visited, int source){
        visited[source]=true;
        for(int i=0;i<graph.length; i++){
            if(graph[source][i]==1 && !visited[i]){
                dfs(graph, visited, i);
            }
        }

    }
}
