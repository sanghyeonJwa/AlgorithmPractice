import java.util.*;
import java.io.*;

public class Main {

    static char[][] paper;
    static boolean[][] visited;
    static boolean isBeautiful = true;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        paper = new char[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String paperInput = br.readLine();

            for(int j = 0; j < m; j++) {
                paper[i][j] = paperInput.charAt(j);
            }
        }

        for (int i = 0; i < n && isBeautiful; i++) {
            for (int j = 0; j < m && isBeautiful; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, n, m);
                }
            }
        }

        System.out.println(isBeautiful ? "dd" : "BaboBabo");

    }

    public static void bfs(int x, int y, int n, int m) {
        char color = paper[x][y];
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});

        int minR = x, maxR = x;
        int minC = y, maxC = y;
        int count = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            count++;

            minR = Math.min(minR, r);
            maxR = Math.max(maxR, r);
            minC = Math.min(minC, c);
            maxC = Math.max(maxC, c);

            for (int d = 0; d < 4; d++) {
                int nx = r + dx[d];
                int ny = c + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m
                        && !visited[nx][ny] && paper[nx][ny] == color) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        int area = (maxR - minR + 1) * (maxC - minC + 1);
        if (count != area) {
            isBeautiful = false;
        }
    }
}

