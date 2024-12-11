import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] computers) {
        
        boolean[] visited = new boolean[n];
        int networks = 0;
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i, computers, visited);
                networks++;
            }
        }
        
        return networks;
    }
    
    public void bfs(int i, int[][] computers, boolean[] visited) {
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        
        while(!queue.isEmpty()) {
            
            int node = queue.poll();
            
            for(int j = 0; j < computers.length; j++) {
                if(computers[node][j] == 1 && !visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }
}