class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // if(prerequisites.length==0) return new int[]{};

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0) q.offer(i);
        }

        int i=0;
        int[] result = new int[numCourses];
        int processed = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            result[i++] = curr;
            processed++;
            for(int neigh : graph.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh]==0) q.offer(neigh);
            }
        }
        return processed==numCourses ? result : new int[0];
    }
}
