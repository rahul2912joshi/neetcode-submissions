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
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        if(intervals.size()<=1) return intervals.size();

        for(Interval interval : intervals){
            start.add(interval.start);
            end.add(interval.end);            
        }

        Collections.sort(start);
        Collections.sort(end);

        int i=1,j=0,rooms=1,result=0;

        while(i<start.size()){
            if(start.get(i) < end.get(j)){
                rooms++;
                i++;
            } else{
                rooms--;
                j++;
            }
            result = Math.max(rooms,result);
        }
        return result;
    }
}
