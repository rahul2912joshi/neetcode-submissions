class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <= 1) return 0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        int count = 0;
        int currentEnd = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            int[] next = intervals[i];
            if(currentEnd > next[0]){
                count++;
            } else{
                currentEnd = next[1];
            }
        }
        return count;
    }
}
