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
        boolean ans[]=new boolean[1];
        ans[0]=true;
        helper(root,mini,maxi,ans);
        return ans[0];
        
    }
    public void helper(TreeNode root,long mini,long maxi,boolean ans[])
    {
        if(root==null)return;
        if(!(root.val>mini && root.val<maxi))
        {
            ans[0]=false;
            return;
            
        }
        if(ans[0]==false)return;
        helper(root.left,mini,root.val,ans);
        helper(root.right,root.val,maxi,ans);
        
        
    }
    
    
}