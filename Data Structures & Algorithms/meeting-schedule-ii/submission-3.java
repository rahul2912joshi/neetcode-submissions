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
        if(intervals.size()==0) return 0;
        int[] start = new int[intervals.size()], end = new int[intervals.size()];
        int k=0;

        for(Interval interval : intervals){
            start[k] = interval.start;
            end[k++] = interval.end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int i = 1, j=0;
        int minRooms = 1, curr = 1;

        while(i<intervals.size()){
            if(start[i] < end[j]){
                curr++;
                i++;
                minRooms = Math.max(minRooms, curr);
            } else{
                curr--;
                j++;
            }
        }
        return minRooms;
    }
}
// 0 5 15
