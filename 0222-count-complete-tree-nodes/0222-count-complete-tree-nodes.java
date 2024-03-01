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
    public int countNodes(TreeNode root) {
        int count[]=new int[1];
        
        helper(root,count);
        return count[0];
    }
    public void helper(TreeNode root,int count[])
    {
        if(root==null)return;
        helper(root.left,count);
        count[0]=count[0]+1;
        helper(root.right,count);
        return;
        
    }
    
}