import java.util.*;

class DisJoint {
    int[] parent, rank;

    DisJoint(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    int findParent(int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent[node]); // Path compression
        }
        return parent[node];
    }

    void unionByRank(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu != pv) {
            if (rank[pu] > rank[pv]) {
                parent[pv] = pu;
            } else if (rank[pu] < rank[pv]) {
                parent[pu] = pv;
            } else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0, maxCol = 0;
        
        // Find the max row and column values
        for (int[] arr : stones) {
            maxRow = Math.max(maxRow, arr[0]);
            maxCol = Math.max(maxCol, arr[1]);
        }

        DisJoint set = new DisJoint(maxRow + maxCol + 2); // Create disjoint set
        
        for (int[] arr : stones) {
            int row = arr[0];
            int col = arr[1] + maxRow + 1; // Offset columns
            
            set.unionByRank(row, col);
        }

        // Count unique parents (connected components)
        Set<Integer> uniqueComponents = new HashSet<>();
        for (int[] arr : stones) {
            uniqueComponents.add(set.findParent(arr[0]));
        }

        return stones.length - uniqueComponents.size();
    }
}
