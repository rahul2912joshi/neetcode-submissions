class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            int[] current = intervals[i];
            if(newInterval[1] < current[0]){
                result.add(newInterval);
                // result.add(current);
                newInterval = current;
            } else if(newInterval[0] > current[1]){
                result.add(current);
            } else{
                newInterval[0] = Math.min(newInterval[0],current[0]);
                newInterval[1] = Math.max(newInterval[1],current[1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}
