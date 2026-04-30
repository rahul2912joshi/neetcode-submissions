class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(newInterval.length==0) return intervals;
        List<int[]> result = new ArrayList<>();

        for(int i=0; i<intervals.length; i++){
            int[] curr = intervals[i];

            if(newInterval[1] < curr[0]){
                result.add(newInterval);
                newInterval = curr;
            } else if(newInterval[0]>curr[1]){
                result.add(curr);
            } else{
                newInterval[0] = Math.min(curr[0],newInterval[0]);
                newInterval[1] = Math.max(curr[1],newInterval[1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
        
    }
}
