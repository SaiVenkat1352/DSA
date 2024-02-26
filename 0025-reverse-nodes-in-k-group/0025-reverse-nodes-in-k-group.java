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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode nextNode = null;
        ListNode prevNode = null;
        ListNode newHead = null;
        
        // Check if there are at least k nodes
        ListNode kthNode = findKthNode(temp, k);
        if (kthNode == null) {
            return head;
        }
        
        while (temp != null) {
            kthNode = findKthNode(temp, k);
            if (kthNode == null) break;
            
            nextNode = kthNode.next;
            kthNode.next = null;
            
            // Reverse the current group
            ListNode reversedGroup = reverse(temp);
            
            // Link the reversed group with the previous group
            if (prevNode != null) {
                prevNode.next = reversedGroup;
            } else {
                newHead = reversedGroup; // Update newHead if reversing the first group
            }
            
            // Move pointers for the next iteration
            prevNode = temp;
            temp = nextNode;
            prevNode.next = temp;
        }
        
        return newHead != null ? newHead : head; // Return new head if it's updated
    }
    
    public ListNode findKthNode(ListNode temp, int k) {
        ListNode pointer = temp;
        for (int i = 0; i < k - 1; i++) {
            if (pointer == null) {
                return null; // Check if there are at least k nodes
            }
            pointer = pointer.next;
        }
        return pointer;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}
