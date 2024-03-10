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
    List<Integer> ds;
    public boolean findTarget(TreeNode root, int k) {
        ds=new ArrayList<Integer>();
        helper1(root);
       
        return helper2(k);
        
      
    }
    public void helper1(TreeNode root)
    {
        if(root==null)return;
        helper1(root.left);
        ds.add(root.val);
        helper1(root.right);
        
    }
    public boolean helper2(int k)
    {
        int i=0;
        int j=ds.size()-1;
        while(i<j)
        {
            if(ds.get(i)+ds.get(j)==k)
            {
                return true;
                
            }
            else if(ds.get(i)+ds.get(j)>k)
            {
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }
   

        
    
}