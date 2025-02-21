import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] box;
    static int[][] days;
    static Queue<int[]> queue = new LinkedList<>();
    
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        box = new int[N][M];
        days = new int[N][M];

        int emptyCount = 0;
        int totalCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j});
                } else if (box[i][j] == -1) {
                    emptyCount++;
                }
                if (box[i][j] != -1) {
                    totalCount++;
                }
            }
        }

        int result = bfs();
        
        // 모든 토마토가 익었는지 확인
        int ripeCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] != -1) {
                    ripeCount++;
                    if (box[i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(result);
    }

    static int bfs() {
        int maxDays = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (box[nx][ny] == 0) {
                        box[nx][ny] = 1;  // 익은 토마토로 변경
                        days[nx][ny] = days[x][y] + 1;
                        maxDays = Math.max(maxDays, days[nx][ny]);
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return maxDays;
    }
}
