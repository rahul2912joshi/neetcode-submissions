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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a,b)->a.val-b.val);
        int k = lists.length;
        for(ListNode list : lists){
            if(list!=null)
                minheap.add(list);
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while(minheap.isEmpty()==false){
            ListNode curr = minheap.poll();
            prev.next = curr;
            prev = curr;
            if(curr.next != null)
                minheap.add(curr.next);
        }
        return dummy.next;
    }
}
// d -> 1 - 1 - 2 3 3 4 5 6
// 
