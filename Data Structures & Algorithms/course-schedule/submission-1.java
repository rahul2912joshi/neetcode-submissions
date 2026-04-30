class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        int[] indegree = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0) q.add(i);
        }

        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            for(int neigh : adj.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }
        return count==numCourses;
    }
}
