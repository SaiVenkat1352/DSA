/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Pair {
    int ind;
    TreeNode root;

    Pair(int ind, TreeNode root) {
        this.ind = ind;
        this.root = root;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> ds = new LinkedList<>();
        ds.add(new Pair(1, root));
        int maxWidth = 0;

        while (!ds.isEmpty()) {
            int size = ds.size();
            int leftMostIndex = ds.peek().ind; // Leftmost index of current level
            int rightMostIndex = leftMostIndex; // Rightmost index of current level

            for (int i = 0; i < size; i++) {
                Pair pair = ds.poll();
                int ind = pair.ind;
                TreeNode node = pair.root;
                rightMostIndex = ind; // Update the rightmost index as we proceed

                if (node.left != null) ds.add(new Pair(2 * ind, node.left));
                if (node.right != null) ds.add(new Pair(2 * ind + 1, node.right));
            }

            // Update the maxWidth
            maxWidth = Math.max(maxWidth, rightMostIndex - leftMostIndex + 1);
        }

        return maxWidth;
    }
}
