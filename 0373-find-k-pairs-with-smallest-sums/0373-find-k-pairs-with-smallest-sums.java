import java.util.*;

class Pair {
    int val;
    int first;
    int second;

    Pair(int val, int first, int second) {
        this.val = val;
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // HashSet to track visited pairs
        Set<String> visited = new HashSet<>();

        pq.add(new Pair(nums1[0] + nums2[0], 0, 0));
        visited.add(0 + "," + 0); // Mark initial pair as visited

        while (k-- > 0 && !pq.isEmpty()) {
            Pair pair = pq.remove();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[pair.first]);
            list.add(nums2[pair.second]);
            res.add(list);

            // Add next possible pairs if they haven't been visited
            if (pair.first + 1 < nums1.length) {
                String key = (pair.first + 1) + "," + pair.second;
                if (!visited.contains(key)) {
                    pq.add(new Pair(nums1[pair.first + 1] + nums2[pair.second], pair.first + 1, pair.second));
                    visited.add(key);
                }
            }

            if (pair.second + 1 < nums2.length) {
                String key = pair.first + "," + (pair.second + 1);
                if (!visited.contains(key)) {
                    pq.add(new Pair(nums1[pair.first] + nums2[pair.second + 1], pair.first, pair.second + 1));
                    visited.add(key);
                }
            }
        }

        return res;
    }
}
