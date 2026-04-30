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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode slow = head, fast=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;

        while(curr!=null){
            ListNode nextnode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextnode;
        }
        ListNode head2 = prev;

        ListNode curr1 = head;
        ListNode curr2=head2;

        while(curr1!=null && curr2!=null){
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;
            curr1.next=curr2;
            curr1=next1;
            curr2.next=curr1;
            curr2=next2;

            
        }
        return;
    }
}
// 2 4 5 6
// 7 8 9 10
