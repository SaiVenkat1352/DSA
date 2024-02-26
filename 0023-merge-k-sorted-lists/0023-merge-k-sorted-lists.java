class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        ListNode res=lists[0];
        for(int i=1;i<lists.length;i++)
        {
            res=merge(res,lists[i]);
        }
        return res;
    }
    public ListNode merge(ListNode head1,ListNode head2)
    {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while(head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                tail.next = head1;
                 head1=head1.next;
            }
            else {
              tail.next = head2;
              head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null)tail.next = head1;
       else tail.next = head2;
       return dummy.next;
    }
    
   
    
      
}
