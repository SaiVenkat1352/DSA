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
    public int maxPathSum(TreeNode root) {
        if(root.left==null && root.right==null)return root.val;
        int maxi[]=new int[1];
        maxi[0]=Integer.MIN_VALUE;
        int a=helper(root,maxi);
        return maxi[0];
        
    }
    public int helper(TreeNode root,int maxi[])
    {
        if(root==null)return 0;
        int left=helper(root.left,maxi);
        if(left<0)left=0;
        int right=helper(root.right,maxi);
        if(right<0)right=0;
        maxi[0]=Math.max(maxi[0],left+right+root.val);
        return root.val+Math.max(left,right);
    }
    
}