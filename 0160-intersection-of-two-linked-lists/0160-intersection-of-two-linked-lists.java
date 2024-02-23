/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode,Integer> map=new HashMap<ListNode,Integer>();
        ListNode tempA=headA;
        while(tempA!=null)
        {
            map.put(tempA,1);
            tempA=tempA.next;
        }
        ListNode tempB=headB;
        while(tempB!=null)
        {
            if(map.containsKey(tempB))
            {
                return tempB;
                
                
            }
            tempB=tempB.next;
        }
        return null;
       
        
        
    }
}