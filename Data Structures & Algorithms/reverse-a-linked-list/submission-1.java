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
        
        ListNode pre=null;
        ListNode next=null;
        ListNode cur=head;
        while(cur!=null) {
            // store next pointer 
            next=cur.next;
            // point cur pointer to previous pointer
            cur.next=pre;
            // update previous pointer 
            pre=cur;
            // move to next
            cur=next;
        }
        head=pre;
        return head;
    }
}
