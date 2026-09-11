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
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int maxRooms = 0;

        for(Interval interval: intervals){
            int startTime = interval.start;
            int endTime = interval.end;
            while(!minHeap.isEmpty() && minHeap.peek() <= startTime){
                minHeap.poll();
            }
            minHeap.offer(endTime);
            maxRooms = Math.max(maxRooms,minHeap.size());
        }

        return maxRooms;

    }
}
