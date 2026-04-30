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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0), curr = head;
        dummy.next = head;
        ListNode prev = dummy;
        while(n>0){
            curr=curr.next;
            n--;
        }
        while(curr!=null){
            curr=curr.next;
            prev=prev.next;
        }
        curr = prev.next;
        prev.next = curr.next;
        curr.next = null;
        return dummy.next;

    }
}
