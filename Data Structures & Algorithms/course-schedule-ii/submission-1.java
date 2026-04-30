class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites){
            int u = pre[1];
            int v = pre[0];
            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> zeroPre = new ArrayDeque<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) zeroPre.offer(i);
        }
        int i=0;
        int processed = 0;
        int[] result = new int[numCourses];
        while(!zeroPre.isEmpty()){
            int curr = zeroPre.poll();
            result[i++]=curr;
            processed++;
            for(int neigh : graph.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh]==0) zeroPre.offer(neigh);
            }
        }
        return processed==numCourses ? result : new int[0];
    }
}
