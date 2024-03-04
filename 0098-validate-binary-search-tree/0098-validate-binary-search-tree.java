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
    public boolean isValidBST(TreeNode root) {
        long mini=Long.MIN_VALUE;
        long maxi=Long.MAX_VALUE;
        return helper(root,mini,maxi);
    }
    public boolean  helper(TreeNode root,long mini,long maxi)
    {
            if(root==null)return true;
            if(root.val<=mini || root.val>=maxi)return false;
            boolean left=helper(root.left,mini,root.val);
            boolean right=helper(root.right,root.val,maxi);
            return left && right;
        
    }
    
    
}