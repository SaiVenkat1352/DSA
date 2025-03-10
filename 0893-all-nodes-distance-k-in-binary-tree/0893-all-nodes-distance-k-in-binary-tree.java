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
        
        
        buildParentMap(root, null, parentMap);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.add(target);
        
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size=queue.size();
            if(level==k)
            {
                while(!queue.isEmpty())
                {
                    TreeNode n=queue.remove();
                    res.add(n.val);
                }
                break;
            }
            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.remove();
                if(node.left!=null && !visited.contains(node.left))
                {
                    visited.add(node.left);
                    queue.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right))
                {
                    visited.add(node.right);
                    queue.add(node.right);
                }
                if(parentMap.containsKey(node) && parentMap.get(node)!=null &&  !visited.contains(parentMap.get(node)))
                {
                    visited.add(parentMap.get(node));
                    queue.add(parentMap.get(node));
                }
            }
            level++;
        }
        return res;

           
    }
    public void buildParentMap(TreeNode root,TreeNode parent,Map<TreeNode,TreeNode> parentMap)
    {
        if(root==null)return ;
        parentMap.put(root,parent);
        buildParentMap(root.left,root,parentMap);
        buildParentMap(root.right,root,parentMap);

    }
    
   
}
