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
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val));
        for(ListNode node : lists){
            if(node != null) pq.add(node);
        }

        ListNode head = new ListNode(-1);
        ListNode prev = head;
        while(!pq.isEmpty()){
            ListNode current = pq.poll();
            prev.next = current;
            prev = current;

            if(current.next != null)
                pq.add(current.next);
        }
        return head.next;
    }
}
