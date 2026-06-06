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

    ListNode KthNode (ListNode head,int k){
        k--;
        while(head!=null && k>0){
            k--;
            head=head.next;
        }
        return head;
    }
    
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prevNode=null;
        ListNode nextNode=null;

        while(temp!=null){
            ListNode kthNode = KthNode(temp,k);
            if(kthNode==null){
                if(prevNode!=null){
                    prevNode.next=temp;
                }
                break;
            }

            nextNode = kthNode.next;
            kthNode.next=null;

            reverse(temp);
            if(head==temp){
                head=kthNode;
            }
            else{
                prevNode.next=kthNode;
            }
            prevNode=temp;
            temp=nextNode;
        }
        return head;

        
    }
}
