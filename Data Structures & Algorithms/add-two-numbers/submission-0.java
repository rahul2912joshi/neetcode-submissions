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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode last = dummy;
        ListNode curr1 = l1, curr2=l2;
        int carry =0;
        while(curr1!=null && curr2!=null){
            int val = curr1.val + curr2.val + carry;
            int sum = val%10;
            carry = val/10;
            ListNode node = new ListNode(sum);
            last.next = node;
            last = node;
            curr1=curr1.next;
            curr2=curr2.next;
        }
        while(curr1!=null){
            int val = curr1.val + carry;
            int sum = val%10;
            carry = val/10;
            ListNode node = new ListNode(sum);
            last.next = node;
            last = node;
            curr1=curr1.next;
        }
        while(curr2!=null){
            int val = curr2.val + carry;
            int sum = val%10;
            carry = val/10;
            ListNode node = new ListNode(sum);
            last.next = node;
            last = node;
            curr2=curr2.next;
        }
        if(carry != 0){
            ListNode node = new ListNode(carry);
            last.next = node;
        }
        return dummy.next;
    }
}
// 2 7 3
// 8 6 3

// 3 7 2
// 3 6 8
