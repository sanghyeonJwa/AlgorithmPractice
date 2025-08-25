import java.util.*;
import java.io.*;

class Solution {
    
    static int n, m;
    static char[][] map;
    static int remainContainer;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0 ,0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(String[] storage, String[] requests) {
        
        /*
        요청 중 단일 알파벳 : 벽이 비어있어야만 접근 가능
        반복된 알파벳 : 그냥 전부 다 뺄 수 있음
        */
        
        n = storage.length;
        m = storage[0].length();
        remainContainer = n * m;
        
        // 패딩을 위해 +2 크기 배열 생성
        map = new char[n + 2][m + 2];
        
        // 패딩 부분은 전부 '.' 으로 채움 (빈칸)
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(map[i], '.');
        }
        
        // 실제 storage 데이터를 (1,1)부터 채움
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = storage[i].charAt(j);
            }
        }
        
        // 로직 구현 (입력 값에 따라서 crane, fork 함수 실행)
        for(String req : requests) {
            char target = req.charAt(0);
            
            if(req.length() >= 2)
                crane(target);
            else 
                fork(target);
        }
        
        // 출력 확인 (패딩 포함)
        for(int i = 0; i < n + 2; i++) {
            for(int j = 0; j < m + 2; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        
        return remainContainer;
    }
    
    // 크레인 작동
    public void crane(char target) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(map[i][j] == target) {
                    map[i][j] = '.';
                    remainContainer--;
                }
            }
        }
    }

    // 지게차 작동
    public void fork(char target) {
        visited = new boolean[n + 2][m + 2];
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        
        List<int[]> targetContainerList = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0]; int y = cur[1];
            
            for(int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx < 0 || ny < 0 || nx >= n + 2 || ny >= m + 2) continue;
                if (visited[nx][ny]) continue;
                
                
                if (map[nx][ny] == '.') {
                    // 빈칸이면 외부 공간 확장
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                } else {
                    // 컨테이너면, 외부 빈칸과 인접한 컨테이너
                    if (map[nx][ny] == target) {
                        targetContainerList.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        for(int[] t : targetContainerList) {
            int tx = t[0]; int ty = t[1];
            
            if(map[tx][ty] != '.') {
                map[tx][ty] = '.';
                remainContainer--;
            }
        }
    }
}