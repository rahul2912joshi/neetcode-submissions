class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> merged = new ArrayList<>();
        //int[] current = intervals[0];
        int i=0;
        for(i = 0; i<intervals.length;i++){
            int[] current = intervals[i];
            if(current[1] < newInterval[0]){
                merged.add(current);
            } else if(newInterval[1] <current[0]){
                merged.add(newInterval);
                break;
            }
            else{
                newInterval[0] = Math.min(current[0], newInterval[0]);
                newInterval[1] = Math.max(current[1], newInterval[1]);
            }
        }
        if(i!=intervals.length){
            for(;i<intervals.length;i++){
                merged.add(intervals[i]);
            } 
        } else{
            merged.add(newInterval);
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
