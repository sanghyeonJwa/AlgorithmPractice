import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < count; i++) {

            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            int[][] cabbage = new int[n][m];
            boolean[][] visited = new boolean[n][m];

            int cabbageAmount = Integer.parseInt(input[2]);

            for(int j = 0; j < cabbageAmount; j++) {
                String[] location = br.readLine().split(" ");
                cabbage[Integer.parseInt(location[0])][Integer.parseInt(location[1])] = 1;
            }

            // 이제 2차원 배열 cabbage가 완성

            int countOfGroups = 0;

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (cabbage[x][y] == 1 && !visited[x][y]) {
                        bfs(x, y, cabbage, visited, n, m, dx, dy);
                        countOfGroups++;
                    }
                }
            }

            answer.add(countOfGroups);
        }

        for (int res : answer) {
            System.out.println(res);
        }
    }


    public static void bfs(int x, int y, int[][] cabbage, boolean[][] visited, int n, int m, int[] dx, int[] dy) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && cabbage[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
