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
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null){
            return head;
        }
        
        ListNode tail = head;
        int length = 1;

        while(tail.next != null){
            tail = tail.next;
            length++;
        }

        int i = 0;
        k = k % length;

        if(k == 0 ){
            return head;
        }

        ListNode curr = head;

        while(i < length - k - 1){
            curr = curr.next;
            i++;
        } 

        ListNode newHead = curr.next;
        curr.next = null;
        tail.next = head;

        return newHead;

    }
}