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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // add indices to map
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        TreeNode res=helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1,map);
        return res;
              
    }
    public TreeNode helper(int[] preorder,int[] inorder,int startPre,int endPre,int startIn,int endIn,Map<Integer,Integer> map)
    {
        if(startPre>endPre || startIn>endIn)
        {
            return null;
        }
        TreeNode node=new TreeNode(preorder[startPre]);
        int rootIndex=map.get(node.val);
        int leftNodes=rootIndex-startIn;
        node.left=helper(preorder,inorder,startPre+1,startPre+leftNodes,startIn,rootIndex,map);
        node.right=helper(preorder,inorder,startPre+leftNodes+1,endPre,rootIndex+1,endIn,map);
        return node;  
    }
}
   