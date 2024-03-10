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
class BSTIterator {
     Stack<TreeNode> ds;
    public BSTIterator(TreeNode root) {
        ds=new Stack<TreeNode>();
        helper(root);
    }
    public int next() {
        TreeNode node=ds.pop();
        if(node.right!=null)helper(node.right);
        return node.val;
        
        
    }
    
    public boolean hasNext() {
        return !ds.isEmpty();
        
    }
    public void helper(TreeNode root)
    {
        while(root!=null)
        {
            ds.push(root);
            root=root.left;
        }
       
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */