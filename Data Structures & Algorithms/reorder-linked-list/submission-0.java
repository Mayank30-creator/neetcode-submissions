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
    ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode curr = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp = reverse(slow);
        ListNode dummy = new ListNode(0);
        int flag=0;
    
        while(curr!=slow){
            if(flag==0){
                dummy.next = curr;
                curr=curr.next;
                flag=1;
            }
            else{
                dummy.next= temp;
                temp=temp.next;
                flag=0;
            }
            dummy=dummy.next;
        }
        dummy.next= (temp!=null)? temp : null;
    }
}
