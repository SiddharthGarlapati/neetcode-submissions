/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)-> a.val - b.val);
        int n = lists.length;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for(int i = 0 ; i < n ; i++){
            if(lists[i] != null){
                minHeap.offer(lists[i]);
            }
        }

        while(!minHeap.isEmpty()){
            ListNode list = minHeap.poll();
            curr.next = list;
            list = list.next;
            if(list != null){
                minHeap.offer(list);
            }
            curr = curr.next;
        }

        return dummy.next;

    }
}
