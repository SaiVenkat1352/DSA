
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Define a priority queue to keep track of the smallest elements
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the heads of all the lists to the minHeap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        // Continue until all lists are merged
        while (!minHeap.isEmpty()) {
            // Get the smallest node from the minHeap
            ListNode smallest = minHeap.poll();

            // Add the smallest node to the merged list
            tail.next = smallest;
            tail = tail.next;

            // Move the pointer of the list from which the smallest node was extracted
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}
