import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] x : edge) {
            graph.get(x[0]).add(x[1]);
            graph.get(x[1]).add(x[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(distance, -1);
        
        q.offer(1);
        distance[1] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : graph.get(cur)) {
                if(distance[next] == -1) {
                    distance[next] = distance[cur] + 1;
                    q.offer(next);
                }
            }
        }
        
        int maxDistance = 0;
        int count = 0;
        for (int dist : distance) {
            if (dist > maxDistance) {
                maxDistance = dist;
                count = 1;
            } else if (dist == maxDistance) {
                count++;
            }
        }

        return count;
    }
}