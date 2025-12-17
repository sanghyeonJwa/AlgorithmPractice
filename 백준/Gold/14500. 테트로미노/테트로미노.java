import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static int n, m;
    static boolean[][] visited;
    static int max = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dfs를 이용하여 5가지 도형 중 4가지 도형 경우 처리
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
                checkT(i, j);
            }
        }

        System.out.println(max);
    }

    // dfs 메소드
    public static void dfs(int x, int y, int depth, int sum) {
        if(depth == 4) {
            max = Math.max(sum, max);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum + map[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    // T 모양 판별 메소드
    public static void checkT(int x, int y) {
        int sum = map[x][y];
        int min = Integer.MAX_VALUE;
        int count = 0;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            sum += map[nx][ny];
            min = Math.min(min, map[nx][ny]);
            count++;
        }

        if(count < 3) return; // T 모양 불가능
        if(count == 4) sum -= min; // 4방향 다 있으면 최소값 빼기

        max = Math.max(max, sum);
    }
}