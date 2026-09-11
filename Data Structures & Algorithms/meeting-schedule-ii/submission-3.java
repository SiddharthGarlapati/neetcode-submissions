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

        if(intervals.size() == 0) return 0;

        intervals.sort((a,b) -> a.start - b.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int rooms = 0;

        for(int i = 0 ; i < intervals.size(); i++){
            int currStart = intervals.get(i).start;
            int currEnd = intervals.get(i).end;
            if(!pq.isEmpty() && pq.peek() <= currStart){
                  pq.poll();
            }

            pq.offer(currEnd);

            rooms = Math.max(rooms , pq.size());

        }

        return rooms;

    }
}
