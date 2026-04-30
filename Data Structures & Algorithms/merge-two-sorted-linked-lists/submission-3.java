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
        ListNode dummy = new ListNode(0);
        ListNode last = dummy;
        ListNode curr1 = list1, curr2 = list2;
        while(curr1!=null && curr2!=null){
            if(curr1.val <= curr2.val){
                last.next = curr1;
                last = curr1;
                curr1 = curr1.next;
            } else{
                last.next = curr2;
                last = curr2;
                curr2 = curr2.next;
            }
        }
        if(curr1==null){
            last.next = curr2;
        } else if(curr2==null){
            last.next = curr1;
        }
        return dummy.next;
    }
}