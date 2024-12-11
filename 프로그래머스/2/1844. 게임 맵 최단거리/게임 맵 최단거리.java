import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // 초기화
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        distance[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] position = q.poll();
        
            int currentX = position[0];
            int currentY = position[1];
            
            if(currentX == n - 1 && currentY == m - 1)
                return distance[currentX][currentY];
            
            for(int i = 0; i < 4; i++) {
                int newX = currentX + dx[i];
                int newY = currentY + dy[i];
                
                if(newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    if(maps[newX][newY] == 1 && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        distance[newX][newY] = distance[currentX][currentY] + 1;
                        q.add(new int[]{newX, newY});
                    }
                }
            }
        }
        
        return -1;
    }
}