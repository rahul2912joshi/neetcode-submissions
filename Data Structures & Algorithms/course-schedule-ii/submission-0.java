class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i< numCourses; i++){
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
        ArrayList<Integer> result = new ArrayList<>();
        while(q.isEmpty()==false){
            int curr = q.poll();
            result.add(curr);
            for(int neigh : adj.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }
        if(result.size()==numCourses){
            int[] res = new int[numCourses];
            for(int i=0; i<numCourses; i++){
                res[i] = result.get(i);
            }
            return res;
        }
        return new int[]{};
    }
}
