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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() <= 1) return true;
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        Interval prev = intervals.get(0), current;
        for(int i=1; i<intervals.size(); i++){
            current = intervals.get(i);
            if(current.start < prev.end) return false;
            prev = current;
        }
        return true;
    }
}
