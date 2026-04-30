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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode curr1 = list1, curr2 = list2, head;
        if(curr1.val < curr2.val) {
            head = curr1;
            curr1 = curr1.next;
        }
        else {
            head = curr2;
            curr2 = curr2.next;
        }
        ListNode itr = head;
        while(curr1 != null && curr2 != null){
            if(curr1.val < curr2.val) {
                itr.next = curr1;
                curr1 = curr1.next;
                itr = itr.next;
            } else{
                itr.next = curr2;
                curr2 = curr2.next;
                itr = itr.next;
            }
        }
        if(curr1 == null) itr.next = curr2;
        else itr.next = curr1;

        return head;
    }
}