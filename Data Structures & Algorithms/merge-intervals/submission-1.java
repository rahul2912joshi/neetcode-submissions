class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        for(int i=1; i<intervals.length; i++){
            int[] next = intervals[i];
            int start = next[0];
            int end = next[1];
            if(current[1] < next[0]){
                result.add(current);
                current = next;
            } else{
                current[1] = Math.max(current[1],next[1]);
            }
        }
        result.add(current);
        int[][] res = new int[result.size()][2];
        for(int i=0; i<result.size();i++){
            res[i][0] = result.get(i)[0];
            res[i][1] = result.get(i)[1];
        }
        return res;
    }
}
