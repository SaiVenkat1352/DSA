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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        Queue<Pair> ds=new LinkedList<>();
        ds.add(new Pair(1,root));
        int maxi=0;
        int leftMostIndex=0;
        int rightMostIndex=0;
        while(ds.size()>0)
        {
            int dsSize=ds.size();
            
            for(int i=0;i<dsSize;i++)
            {
                Pair pair=ds.poll();
                int ind=pair.ind;
                TreeNode node=pair.root;
                if(i==0)leftMostIndex=ind;
                if(i==dsSize-1)rightMostIndex=ind;
                if(node.left!=null)ds.add(new Pair(2*ind-1,node.left));
                if(node.right!=null)ds.add(new Pair(2*ind,node.right));
                
                
            }
            maxi=Math.max(rightMostIndex-leftMostIndex+1,maxi);
        }
        return maxi;
        
    }
} 