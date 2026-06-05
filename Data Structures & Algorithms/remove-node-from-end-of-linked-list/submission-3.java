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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null) return null;
        if(head.next.next==null && n==1){
            head.next=null;
            return head;
        }
        if(head.next.next==null && n==2) return head.next; 
        ListNode curr=head;
        int count=0;
        while(curr!=null){
            curr=curr.next;
            count++;
        }
        
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if(count==n) return head.next;
        for(int i=0;i<=count-n-1;i++){
            dummy=dummy.next;
        }
        if(dummy.next!=null){
            dummy.next=dummy.next.next;
        }
        
        return head;
    }
}
