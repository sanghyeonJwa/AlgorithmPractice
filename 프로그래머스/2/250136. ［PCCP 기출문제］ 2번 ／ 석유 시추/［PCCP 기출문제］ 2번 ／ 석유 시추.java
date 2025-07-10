import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int n, m;
    static int id = 2;

    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        Map<Integer, Integer> idToOil = new HashMap<>();

        // step1: land 전체에서 석유 덩어리를 BFS로 탐색 → id 부여, 크기 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int oil = bfs(i, j, land, id);
                    idToOil.put(id, oil);
                    id++;
                }
            }
        }

        // step2: 각 열에 대해 석유 덩어리 id만 수집해서 합산
        int maxOil = 0;
        for (int col = 0; col < m; col++) {
            Set<Integer> used = new HashSet<>();
            int sum = 0;

            for (int row = 0; row < n; row++) {
                int curId = land[row][col];
                if (curId > 1 && !used.contains(curId)) {
                    sum += idToOil.get(curId);
                    used.add(curId);
                }
            }

            maxOil = Math.max(maxOil, sum);
        }

        return maxOil;
    }

    public int bfs(int x, int y, int[][] land, int id) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        land[x][y] = id;

        int count = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] || land[nx][ny] != 1) continue;

                visited[nx][ny] = true;
                land[nx][ny] = id;
                q.add(new int[]{nx, ny});
                count++;
            }
        }

        return count;
    }
}