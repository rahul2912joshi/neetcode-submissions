/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];
        for(int i=0; i<intervals.size(); i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int maxDays = 0, days=0;
        int i = 0, j=0;
        while(i<starts.length){
            if(starts[i] < ends[j]){
                days++;
                maxDays = Math.max(days, maxDays);
                i++;
            } else{
                days--;
                j++;
            }
        }
        return maxDays;
    }
}
