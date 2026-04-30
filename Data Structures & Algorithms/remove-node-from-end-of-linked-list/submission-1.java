/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }54   1 2 3 4 5 6 7 8 9
 */ 

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0) return head;
        ListNode curr = head, prev = head;
        while(n>0){
            curr = curr.next;
            n--;
        }
        while(curr!=null && curr.next!=null){
            prev = prev.next;
            curr=curr.next;
        }
        if(curr==null){
            prev = head;
            head = head.next;
            prev.next = null;
        } else{
            curr = prev.next;
            prev.next = curr.next;
            curr.next = null;
        }
        return head;
    }
}
