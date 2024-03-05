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
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insertIntoBST(root, preorder[i]);
        }
        return root;
    }
    
    private void insertIntoBST(TreeNode root, int val) {
        TreeNode parent = root;
        TreeNode newNode = new TreeNode(val);
        while (true) {
            if (val < parent.val) {
                if (parent.left == null) {
                    parent.left = newNode;
                    break;
                } else {
                    parent = parent.left;
                }
            } else {
                if (parent.right == null) {
                    parent.right = newNode;
                    break;
                } else {
                    parent = parent.right;
                }
            }
        }
    }
}
