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
class Pair{
    int ind;
    TreeNode root;
    Pair(int ind,TreeNode root)
    {
        this.ind=ind;
        this.root=root;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null)return res;
        Queue<Pair> ds=new LinkedList<>();
        ds.add(new Pair(0,root));
        while(ds.size()>0)
        {
            int dsSize=ds.size();
            for(int i=0;i<dsSize;i++)
            {
                Pair pair=ds.poll();
                int ind=pair.ind;
                TreeNode node=pair.root;
                if(i==dsSize-1)res.add(node.val);
                if(node.left!=null)ds.add(new Pair(ind+1,node.left));
                if(node.right!=null)ds.add(new Pair(ind+1,node.right));
            }
        }
        return res;
        
    }
        
        
    
    
}