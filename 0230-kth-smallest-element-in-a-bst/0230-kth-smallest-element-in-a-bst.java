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
    static int count;
    static int res;
    public int kthSmallest(TreeNode root, int k) {
        count=0;
        res=0;
        
        helper(root,k);
        return res;
    }
    public void helper(TreeNode root,int k)
    {
        if(root==null)return ;
        if(count<k){
            helper(root.left,k);
            count++;
            if(count==k){
                res=root.val;
                return;
            }
             
            helper(root.right,k);

        }
       
        
    }
    
}