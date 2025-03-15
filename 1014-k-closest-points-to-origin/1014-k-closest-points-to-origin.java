import java.util.PriorityQueue;

class Node {
    int points[];
    int sqrt;
    Node(int points[], int sqrt) {
        this.points = new int[2];
        this.points[0] = points[0];
        this.points[1] = points[1];
        this.sqrt = sqrt;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> b.sqrt - a.sqrt);

        for (int[] arr : points) {
            int sqrt = helper(arr);
            maxHeap.add(new Node(arr, sqrt));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] ans = new int[maxHeap.size()][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            int[] sub = maxHeap.poll().points;
            ans[i][0] = sub[0];
            ans[i][1] = sub[1];
            i++;
        }
        return ans;
    }

    private int helper(int[] point) {
        // This function calculates the square of the Euclidean distance from the origin (0, 0)
        return point[0] * point[0] + point[1] * point[1];
    }
}
