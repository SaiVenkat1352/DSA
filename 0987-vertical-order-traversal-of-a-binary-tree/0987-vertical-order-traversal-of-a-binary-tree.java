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



import java.util.*;


class Pair {
    int v; // vertical
    int h; // horizontal
    TreeNode root;

    Pair(int v, int h, TreeNode root) {
        this.v = v;
        this.h = h;
        this.root = root;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Pair> ds = new LinkedList<>();
        if (root != null)
            ds.add(new Pair(0, 0, root));

        while (!ds.isEmpty()) {
            int dSize = ds.size();
            for (int i = 0; i < dSize; i++) {
                Pair pair = ds.remove();
                int v = pair.v;
                int h = pair.h;
                TreeNode node = pair.root;
                
                if (!map.containsKey(h)) {
                    map.put(h, new TreeMap<>());
                }
                
                TreeMap<Integer, List<Integer>> levelMap = map.get(h);
                if (!levelMap.containsKey(v)) {
                    levelMap.put(v, new ArrayList<>());
                }
                levelMap.get(v).add(node.val);

                if (node.left != null) ds.add(new Pair(v + 1, h - 1, node.left));
                if (node.right != null) ds.add(new Pair(v + 1, h + 1, node.right));
            }
        }

        for (TreeMap<Integer, List<Integer>> levelMap : map.values()) {
            List<Integer> levelList = new ArrayList<>();
            for (List<Integer> list : levelMap.values()) {
                Collections.sort(list);
                levelList.addAll(list);
            }
            res.add(levelList);
        }

        return res;
    }
}
