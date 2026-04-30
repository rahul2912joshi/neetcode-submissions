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
        if(intervals.size() <= 1) return intervals.size();

        //Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        int[] start = new int[intervals.size()], end = new int[intervals.size()];

        for(int i=0; i<intervals.size(); i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int i=0, j=0, activeMeeting=0, maxOverlap=0;

        while(i<start.length){
            if(start[i] < end[j]){
                activeMeeting++;
                maxOverlap = Math.max(activeMeeting, maxOverlap);
                i++;
            } else{
                activeMeeting--;
                j++;
            }
        }
        return maxOverlap;
    }
}
