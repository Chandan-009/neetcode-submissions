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
    public void reorderList(ListNode head1) {

        ListNode mid=findMidNode(head1);
        ListNode head2=reverseListNode(mid.next);
        mid.next=null;
       // printListNode(head2);
        mergerListNodes(head1,head2);
        
    }

    public static void mergerListNodes(ListNode head1, ListNode head2){
        printListNode(head1);
        System.out.println();
        printListNode(head2);
        ListNode cur1=head1;
        ListNode cur2=head2;
        ListNode next1=head1;
        ListNode next2=head2;

        while(cur1!=null&&cur2!=null){
            next1=cur1.next;
            next2=cur2.next;
            cur1.next=cur2;
            cur1=next1;
            cur2.next=cur1;
            cur2=next2;
        }

    }

    public static ListNode reverseListNode(ListNode head){
        ListNode cur=head;
        ListNode prev=null;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }

    public static ListNode findMidNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        System.out.println();
        while(fast!=null && fast.next!=null){
           // System.out.print(fast.val+" ");
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println();
        return slow;
    }

    public static void printListNode(ListNode head){
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }
}
