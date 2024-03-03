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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // add indices to map
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        TreeNode res=helper(postorder,inorder,0,postorder.length-1,0,inorder.length-1,map);
        return res;
              
    }
    public TreeNode helper(int[] postorder,int[] inorder,int startPre,int endPre,int startIn,int endIn,Map<Integer,Integer> map)
    {
        if(startPre>endPre || startIn>endIn)
        {
            return null;
        }
        TreeNode node=new TreeNode(postorder[endPre]);
        int rootIndex=map.get(node.val);
        int leftNodes=rootIndex-startIn;
        node.left=helper(postorder,inorder,startPre,startPre+leftNodes-1,startIn,rootIndex-1,map);
        node.right=helper(postorder,inorder,startPre+leftNodes,endPre-1,rootIndex+1,endIn,map);
        return node;  
    }
}
   
