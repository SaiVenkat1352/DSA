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
    public int kthSmallest(TreeNode root, int k) {
        Stack<Integer> ds=new Stack<>();
        helper(root,ds,k);
        return ds.pop();
    }
    public void helper(TreeNode root,Stack<Integer> ds,int k)
    {
        if(root==null)return ;
       
        helper(root.left,ds,k);
        if(ds.size()==k)return;
        ds.add(root.val);
        helper(root.right,ds,k);
    }
    
}