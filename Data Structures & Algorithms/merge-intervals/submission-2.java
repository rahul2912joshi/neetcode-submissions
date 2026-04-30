class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
        ArrayList<int[]> result = new ArrayList<>();
        if(intervals.length == 0) return new int[0][];
        int[] last = intervals[0];
        for(int i=1; i<intervals.length; i++){
            int[] curr = intervals[i];
            if(last[1] < curr[0]){
                result.add(last);
                last = curr;
            } else{
                last[0] = Math.min(last[0],curr[0]);
                last[1] = Math.max(last[1],curr[1]);
            }
        }
        result.add(last);
        return result.toArray(new int[result.size()][]);
    }
}
