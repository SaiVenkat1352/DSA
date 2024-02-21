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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode prev=dummy;
        ListNode temp=head;
        
         if(head==null)return null;
        while(temp.next!=null)
        {
            if(temp.val!=temp.next.val)
            {
                prev=prev.next;
                temp=temp.next;
            }
            else{
                while(temp.next!=null && temp.val==temp.next.val)
                {
                    temp=temp.next;

                }
                prev.next=temp.next;
                temp=temp.next;
                if(temp==null)break;
                
            }
        }
        return dummy.next;
       
    }
}