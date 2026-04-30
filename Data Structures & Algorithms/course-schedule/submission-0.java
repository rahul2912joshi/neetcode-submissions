class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());
        for(int[] val : prerequisites){
            int u = val[0], v = val[1];
            adj.get(v).add(u);
        }

        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int neigh : adj.get(i)){
                indegree[neigh]++;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0) pq.add(i);
        }

        int count = 0;
        while(!pq.isEmpty()){
            int curr = pq.poll();
            count++;
            for(int neigh : adj.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh] == 0) pq.add(neigh);
            }
        }
        if(count==numCourses) return true;
        return false;
    }
}
