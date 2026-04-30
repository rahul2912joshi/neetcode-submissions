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
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = head, slow = dummy;
        while(n!=1){
            fast = fast.next;
            n--;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode temp = slow.next;
        slow.next = temp.next;
        temp.next = null;
        return dummy.next;
    }
}
