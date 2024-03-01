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
    public int amountOfTime(TreeNode root1, int start) {
        TreeNode root=findStart(root1,start);

        Queue<TreeNode> ds = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        ds.add(root);
        visited.add(root);

        // build a parent map
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParent(root1, null, parentMap);

        int time = 0;

        while (!ds.isEmpty()) {
            int size = ds.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = ds.remove();

                // check if this is the starting node
                

                if (node.left != null && !visited.contains(node.left)) {
                    ds.add(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    ds.add(node.right);
                    visited.add(node.right);
                }
                TreeNode parent = parentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    ds.add(parent);
                    visited.add(parent);
                }
            }
            time++;
        }
        return time-1; // indicating start node not found
    }

    public void buildParent(TreeNode current, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (current == null) {
            return;
        }
        parentMap.put(current, parent);
        buildParent(current.left, current, parentMap);
        buildParent(current.right, current, parentMap);
    }
    public TreeNode findStart(TreeNode root,int start)
    {
        if(root==null)return null;
        if(root.val==start)return root;
        TreeNode left=findStart(root.left,start);
        TreeNode right=findStart(root.right,start);
        if(left == null && right == null )return null;
        if(left!=null)return left;
        return right;
        
    }
}