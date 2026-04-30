/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * } 25
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head, prev=null, next;
        ListNode revlast = curr, lastprev = prev;
        int i;
        while(curr!=null){
            i=0;
            ListNode itr = curr;
            while(itr!=null && i<k-1){
                itr=itr.next;
                i++;
            }
            if(itr==null) break;
            revlast = curr;
            lastprev = prev;
            i = 0;
            while(curr!=null && i<k){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                i++;
            }
            if(lastprev!=null){
                lastprev.next = prev;
            } else{
                head = prev;
            }
            revlast.next = curr;
            prev = revlast;
        }
        return head;
    }
}
