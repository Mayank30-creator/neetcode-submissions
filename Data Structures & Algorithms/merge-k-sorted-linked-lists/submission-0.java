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
        PriorityQueue<ListNode>pq = new PriorityQueue<>((a,b)-> a.val-b.val);
        for(ListNode node:lists){
            if(node!=null){
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(pq.size()!=0){
            ListNode curr = pq.poll();

            temp.next=curr;
            temp=temp.next;
            curr=curr.next;

            if(curr!=null){
                pq.add(curr);
            }
        }
        return dummy.next;
    }
}
