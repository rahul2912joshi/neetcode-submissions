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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev;
        ListNode curr = head;
        ListNode lastOfPrev = dummy, firstOfCurr, lastOfCurr;

        while(curr!=null){
            int len=1;
            ListNode temp = curr;
            while(temp!=null && len<k){
                temp=temp.next;
                len++;
            }
            if(temp==null) return dummy.next;
            len=1;
            prev = null;
            lastOfCurr = curr;
            while(curr!=null && len<=k){
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                len++;
            }
            firstOfCurr = prev;
            lastOfPrev.next = firstOfCurr;
            lastOfCurr.next = curr;
            lastOfPrev = lastOfCurr;
        }
        return dummy.next;
    }
}
// // 1 2 3 4 5 6 7 8
// prev.next = rev(1);
// prev = 1;
// d <-1 <-2 <-3 4->5->6->7->8
// curr = firstofthis
// prev = lastofthis
// lastofprev.next = firstofthis;
// lastofprev = lastofthis;

// prev=null;
// next = curr.next;
// curr.next = prev;
// curr = next;

// // 3 2 1 6 5 4 7 8
