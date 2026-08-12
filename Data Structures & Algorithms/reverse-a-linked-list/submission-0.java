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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode pre_pointer=null;
        ListNode next_pointer=null;
        ListNode temp=head;
        while(temp!=null) {
            // store next pointer 
            next_pointer=temp.next;
            // point cur pointer to previous pointer
            temp.next=pre_pointer;
            // update previous pointer 
            pre_pointer=temp;
            // move to next
            temp=next_pointer;
        }
        head=pre_pointer;
        return head;
    }
}
