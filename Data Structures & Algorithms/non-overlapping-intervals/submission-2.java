class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int[] curr = intervals[0];
        int count = 0;
        for(int i=1; i<intervals.length; i++){
            int[] next = intervals[i];
            if(next[0]<curr[1]){
                count++;
            } else{
                curr = next;
            }
        }
        return count;
    }
}
