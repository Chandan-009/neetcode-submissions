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
    public  ListNode addTwoNumbers(ListNode cur1, ListNode cur2) {
        int carry=0;
        int result=0;
        ListNode l1=cur1;
        ListNode l2=cur2;
        ListNode pre1=l1;
        ListNode pre2=l2;
        int count1=0,count2=0;
        while(l1!=null || l2!=null) {
            int first= (l1!=null)?l1.val:0;
            int second= (l2!=null)?l2.val:0;
            int sum=first+second+carry;
            if(sum>=10){
                carry=sum/10;
                result=sum%10;
            }
            else {
                carry=0;
                result=sum;
            }
            if(l1!=null){
                count1++;
                l1.val=result;
                pre1=l1;
                l1=l1.next;
            }
            if(l2!=null){
                count2++;
                l2.val=result;
                pre2=l2;
                l2=l2.next;
            }

        }

        if(carry==0){
            return (count1>count2)? cur1:cur2;
        }
        if(carry>0){
            ListNode head=new ListNode(carry);
            if(count1>count2){
                pre1.next=head;
            }
            else {
                pre2.next=head;
            }
        }
        return (count1>count2)? cur1:cur2;
    }

    
}
