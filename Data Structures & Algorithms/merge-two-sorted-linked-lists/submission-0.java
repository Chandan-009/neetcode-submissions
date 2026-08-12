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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;

        ListNode head=null;
        ListNode cur=new ListNode();
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                //point cur to the least
                cur.next=list1;
                //move the pointer
                list1=list1.next;
            }
            else {
                //point cur to the least
                cur.next=list2;
                //move the pointer
                list2=list2.next;
            }
            cur=cur.next;
            if(head==null){
                head=cur;
            }
        }

        if(list1==null){
            cur.next=list2;
        }
        else{
            cur.next=list1;
        }
        return head;
    }
}