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
        if (head == null || head.next == null)
            return head;

        Map<Integer, Integer> map = new HashMap<>();
        ListNode temp = head;

        // Count the occurrences of each value
        while (temp != null) {
            map.put(temp.val, map.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        temp = head;

        // Traverse again to link non-duplicate nodes
        while (temp != null) {
            if (map.get(temp.val) == 1) {
                ListNode newNode = new ListNode(temp.val);
                prev.next = newNode;
                prev = newNode;
            }
            temp = temp.next;
        }

        return dummy.next;
    }
}