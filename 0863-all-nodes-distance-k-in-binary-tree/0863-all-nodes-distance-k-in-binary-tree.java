/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        
        // First, build the parent map
        buildParentMap(root, null, parentMap);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.add(target);
        
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            if (level == k) {
                for (int i = 0; i < size; i++) {
                    res.add(queue.poll().val);
                }
                return res;
            }
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                if (node.left != null && visited.add(node.left)) {
                    queue.offer(node.left);
                }
                
                if (node.right != null && visited.add(node.right)) {
                    queue.offer(node.right);
                }
                
                TreeNode parent = parentMap.get(node);
                if (parent != null && visited.add(parent)) {
                    queue.offer(parent);
                }
            }
            
            level++;
        }
        
        return res;
    }
    
    private void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) return;
        parentMap.put(node, parent);
        buildParentMap(node.left, node, parentMap);
        buildParentMap(node.right, node, parentMap);
    }
}
