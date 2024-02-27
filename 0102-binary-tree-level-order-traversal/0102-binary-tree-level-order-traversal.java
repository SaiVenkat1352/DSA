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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> ds=new LinkedList<>();
        ds.add(root);
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)return res;
        while(!ds.isEmpty())
        {
            List<Integer> sub=new ArrayList<>();
            int size=ds.size();
            for(int i=0;i<size;i++)
            {
                TreeNode a=ds.remove();
                sub.add(a.val);
                if(a.left!=null)ds.add(a.left);
                if(a.right!=null)ds.add(a.right);
            }
            res.add(sub);
            
        }
        return res;

        
    }
}