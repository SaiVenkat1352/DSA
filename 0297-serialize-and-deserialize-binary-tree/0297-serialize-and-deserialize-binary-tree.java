/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        helper(root,sb);
        return sb.toString();
      
    }
    public void helper(TreeNode root,StringBuilder sb)
    {
        if(root==null){
            sb.append("n ");
            return;
        }
        sb.append(root.val+" ");
        helper(root.left,sb);
        helper(root.right,sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> ds=new LinkedList<>(Arrays.asList(data.split(" ")));
        return helper1(ds);
       
       
        
        
    }
    public TreeNode helper1(Queue<String> queue)
    {
        String val=queue.poll();
        if(val.equals("n"))return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left=helper1(queue);
        root.right=helper1(queue);
        return root;


    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));