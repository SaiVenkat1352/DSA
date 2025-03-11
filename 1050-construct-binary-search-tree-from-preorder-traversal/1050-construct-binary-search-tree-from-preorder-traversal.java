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
    public TreeNode bstFromPreorder(int[] preorder) {
        int n=preorder.length;
        int inorder[]=new int[n];
        int k=0;
        
        for(int ele:preorder)
        {
            
            inorder[k]=ele;
            k++;
        }
        Arrays.sort(inorder);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        TreeNode res=helper(preorder,0,n-1,inorder,0,n-1,map);
        return res;
            
    }
    public TreeNode helper(int preorder[],int preStart,int preEnd,int inorder[],int inStart,int inEnd,Map<Integer,Integer> map)
    {
        //base case
        if(preStart>preEnd || inStart>inEnd)return null;


        int root=preorder[preStart];
        int inroot=map.get(root);
        int numsLeft=inroot-inStart;
        TreeNode node=new TreeNode(root);
        node.left=helper(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inroot-1,map);
        node.right=helper(preorder,preStart+numsLeft+1,preEnd,inorder,inroot+1,inEnd,map);
        return node;
        

    }
    
    
    
}
