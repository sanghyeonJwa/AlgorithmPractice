import java.util.*;
import java.io.*;

class Solution {
    
    static class Node implements Comparable<Node> {
        int to, time;

        public Node(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time; 
        }
    }
    
    static List<List<Node>> graph;
    static int[] dist;

    public int solution(int N, int[][] road, int K) {
        
        dist = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int[] r : road) {
            int a = r[0], b = r[1], t = r[2];
            graph.get(a).add(new Node(b, t));
            graph.get(b).add(new Node(a, t));
        }
        
        dijkstra(1);

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) count++;
        }

        return count;
    }

    public void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.to] < now.time) continue;

            for (Node next : graph.get(now.to)) {
                int cost = dist[now.to] + next.time;
                if (cost < dist[next.to]) {
                    dist[next.to] = cost;
                    pq.offer(new Node(next.to, cost));
                }
            }
        }
    }
}