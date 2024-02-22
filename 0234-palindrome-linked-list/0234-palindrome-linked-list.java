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
    public boolean isPalindrome(ListNode head) {
       ListNode slow=head;
         ListNode fast=head;
        if(fast.next==null)return true;
        if(fast.next.next==null)
        {
            if(fast.val==fast.next.val)return true;
            return false;
        }
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            
        }
        ListNode newNode=helper(slow.next);
        ListNode temp=newNode;
        while(temp!=null)
        {
            if(temp.val!=head.val)return false;
            head=head.next;
            temp=temp.next;
        }
        return true;
        

        
    }
    public ListNode helper(ListNode head)
    {
        ListNode prev=null;
        ListNode temp=head;
        while(temp!=null)
        {
            temp=temp.next;
            head.next=prev;
            prev=head;
            head=temp;
        }
        return prev;
    }
    
}