class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <=1) return intervals;
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));

        int[] prev = intervals[0];

        for(int i=1; i<intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[0] > prev[1]){
                result.add(prev);
                prev = curr;
            } else{
                prev[0] = Math.min(prev[0],curr[0]);
                prev[1] = Math.max(prev[1],curr[1]);
            }
        }
        result.add(prev);
        return result.toArray(new int[result.size()][]);
    }
}
