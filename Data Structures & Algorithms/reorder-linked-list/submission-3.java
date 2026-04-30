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
        if(head==null || head.next == null || head.next.next == null) return;
        ListNode slow = head, fast = head;
        while(fast.next !=null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode startOfSecond = reverseList(slow.next);
        ListNode first = head, second = startOfSecond; 
        slow.next = null;
        while(first != null && second != null){
            ListNode temp = first.next;
            first.next = second;
            first = temp;
            if(first == null) return;
            temp = second.next;
            second.next = first;
            second = temp;
        }
        return;
    }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = null, curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

// 2 4 6 8 10
// 2 4 6 10 8

// 2 10 4 8 6
