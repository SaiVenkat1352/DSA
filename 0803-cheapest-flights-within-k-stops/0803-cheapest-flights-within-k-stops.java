import java.util.*;

class Pair {
    int node;
    int price;
    Pair(int node, int price) {
        this.node = node;
        this.price = price;
    }
}

class Tuple {
    int dis;
    int node;
    int stops;
    Tuple(int dis, int node, int stops) {
        this.dis = dis;
        this.node = node;
        this.stops = stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Step 1: Form adjacency list
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int u = flight[0], v = flight[1], price = flight[2];
            adjList.get(u).add(new Pair(v, price));
        }

        // Step 2: Initialize priority queue with (distance, node, stops)
        Queue<Tuple> pq = new LinkedList<>();
        pq.add(new Tuple(0, src, 0));

        // Step 3: Distance array initialized with Infinity
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        // Step 4: BFS + Dijkstra approach
        while (!pq.isEmpty()) {
            Tuple tuple = pq.poll();
            int distance = tuple.dis;
            int flight = tuple.node;
            int stops = tuple.stops;

            // If reached destination, return the cost
            //if (flight == dst) return distance;

            // If stops exceed limit, continue
            if (stops > k) continue;

            // Explore neighbors
            for (Pair p : adjList.get(flight)) {
                int newFlight = p.node;
                int newDis = p.price;

                if (distance + newDis < dis[newFlight]) {
                    dis[newFlight] = distance + newDis;
                    pq.add(new Tuple(distance + newDis, newFlight, stops + 1));
                }
            }
        }

        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];
    }
}
