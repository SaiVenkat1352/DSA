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
    static int last;
    static int mini;
    public int minDiffInBST(TreeNode root) {
        last=-1;
        mini=Integer.MAX_VALUE;
        helper(root);
        return mini;
        
    }
    public void helper(TreeNode root)
    {
        if(root==null)return;
        helper(root.left);
        if(last==-1)last=root.val;
        else{
            mini=Math.min(Math.abs(last-root.val),mini);
            last=root.val;
        }
        helper(root.right);
    }
}