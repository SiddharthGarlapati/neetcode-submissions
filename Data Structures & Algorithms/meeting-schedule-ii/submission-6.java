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

        intervals.sort((a,b) -> a.start - b.start);

        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b) -> a.end - b.end);
        int maxRooms = 0;

        for(Interval interval: intervals){
            while(!minHeap.isEmpty() && minHeap.peek().end <= interval.start){
                minHeap.poll();
            }
            minHeap.offer(interval);

            maxRooms = Math.max(maxRooms, minHeap.size());
        }

        return maxRooms;


    }
}
