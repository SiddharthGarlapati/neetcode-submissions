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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int i = 0;

        ListNode curr = dummy;
        ListNode leftPrev = null;

        while( i < left){
            leftPrev = curr;
            curr = curr.next;
            i++;
        }

        ListNode prev = null;

        i = 0;

        while(i < right - left + 1){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        leftPrev.next.next = curr;
        leftPrev.next = prev;
        
        return dummy.next;
    }
}