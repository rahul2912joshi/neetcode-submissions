class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];

        for(int[] prereq : prerequisites){
            int u = prereq[1];
            int v = prereq[0];
            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0) q.offer(i);
        }

        int coursesTaken = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            coursesTaken++;
            for(int neigh : graph.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh]==0) q.offer(neigh);
            }
        }

        return numCourses==coursesTaken;
    }
}
