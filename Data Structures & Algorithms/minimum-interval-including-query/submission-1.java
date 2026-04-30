class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        HashMap<Integer,Integer> shortest = new HashMap<>();
        for(int i=0; i<intervals.length;i++){
            int[] current = intervals[i];
            int length = current[1]-current[0]+1;
            for(int j=current[0];j<=current[1];j++){
                if(!shortest.containsKey(j)){
                    shortest.put(j,length);
                } else{
                    int newlen = Math.min(shortest.get(j),length);
                    shortest.put(j,newlen);
                }
            }
        }
        int[] result = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            result[i] = shortest.containsKey(queries[i]) ? shortest.get(queries[i]) : -1;
        }
        return result;
    }
}
// Check optimal solution:
// using binary search
