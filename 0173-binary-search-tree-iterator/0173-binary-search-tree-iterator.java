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
     Queue<Integer> ds;
    public BSTIterator(TreeNode root) {
        ds=new LinkedList<Integer>();
        helper(root);
    }
    public int next() {
        return ds.remove();
        
    }
    
    public boolean hasNext() {
        return !ds.isEmpty();
        
    }
    public void helper(TreeNode root)
    {
        if(root==null)return;
        helper(root.left);
        ds.add(root.val);
        helper(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */