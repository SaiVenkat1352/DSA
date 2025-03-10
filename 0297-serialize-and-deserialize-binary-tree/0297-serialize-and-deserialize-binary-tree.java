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
        Queue<TreeNode> ds=new LinkedList<>();
        ds.add(root);
        while(!ds.isEmpty())
        {
            
                TreeNode node=ds.remove();
                if(node==null){
                    sb.append("n ");
                    continue;
                }
                sb.append(node.val+" ");
                ds.add(node.left);
                ds.add(node.right);
                
            
        }
        return sb.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String values[]=data.split(" ");
        if(values[0].equals("n"))return null;
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> ds=new LinkedList<>();
        ds.add(root);
        for(int i=1;i<values.length;i++)
        {
            TreeNode node=ds.remove();
            if(!values[i].equals("n"))
            {
                TreeNode left=new TreeNode(Integer.parseInt(values[i]));
                node.left=left;
                ds.add(left);
                
            }
            if(!values[++i].equals("n"))
            {
                TreeNode right=new TreeNode(Integer.parseInt(values[i]));
                node.right=right;
                ds.add(right);
                
            }
        }
        return root;
        
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));