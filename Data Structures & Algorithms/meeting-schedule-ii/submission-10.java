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

        intervals.sort((a,b) -> Integer.compare(a.start,b.start));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int rooms = 0;

        for(Interval interval : intervals){
            int currStart = interval.start;
            int currEnd = interval.end;

            if(!minHeap.isEmpty() && currStart >= minHeap.peek()){
                minHeap.poll();
            }
            minHeap.offer(currEnd);
            rooms = Math.max(rooms,minHeap.size());
        }

        return rooms;


    }
}
