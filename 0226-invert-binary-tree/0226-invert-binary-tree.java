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
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;

        
    }
    void helper(TreeNode root)
    {
        if(root==null)return ;
       
        helper(root.left);
        helper(root.right);
         if(root.left==null && root.right==null)return;
        
        else{
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;
        }
        
    }
}