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
        TreeNode root=new TreeNode(preorder[0]);
        for(int i=1;i<n;i++)
        {
            TreeNode temp=root;
            while(temp!=null)
            {
                if(preorder[i]<temp.val)
                {
                    if(temp.left!=null)temp=temp.left;
                    else{
                        temp.left=new TreeNode(preorder[i]);
                        break;
                    }
                }
                else{
                    if(temp.right!=null)temp=temp.right;
                    else{
                        temp.right=new TreeNode(preorder[i]);
                        break;
                    }

                }
            }

        }
        return root;
           
        
            
    }
    
    
    
}
