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
    public ListNode sortList(ListNode head) {
        // merge sort 
        if(head==null || head.next==null)return head;
        //middle node
        ListNode middle=findMiddle(head);
        ListNode rightPortion=middle.next;
        
        
        ListNode leftPortion=head;
        middle.next=null;
        //left recursion
        ListNode left=sortList(leftPortion);
        //right recursion
        ListNode right=sortList(rightPortion);
        // calling a merge function
        return merge(left,right);
        
        
    }
    public ListNode findMiddle(ListNode head)
    {
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode merge(ListNode l1,ListNode l2)
    {
        ListNode result=new ListNode();
        ListNode temp=result;
        while(l1!=null && l2!=null)
        {
            if(l1.val<=l2.val)
            {
                temp.next=l1;
                l1=l1.next;
            }
            else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        if (l1 != null) {
        temp.next = l1;
        } else {
        temp.next = l2;
        }
        return result.next;
        
    }
}