import java.util.*;
import java.io.*;

public class Main {

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, l, r;
    static int[][] population;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        population = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int totalDays = 0;

        while (true) {
            visited = new boolean[n][n];
            boolean hasMoved = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            hasMoved = true;
                        }
                    }
                }
            }

            if (!hasMoved) break;
            totalDays++;
        }

        System.out.println(totalDays);
    }

    public static boolean bfs(int startX, int startY) {

        Queue<Position> queue = new LinkedList<>();
        List<Position> union = new ArrayList<>();

        queue.add(new Position(startX, startY));
        union.add(new Position(startX, startY));
        visited[startX][startY] = true;

        int totalPopulation = population[startX][startY];

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = current.x + dx[dir];
                int ny = current.y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    int gap = Math.abs(population[current.x][current.y] - population[nx][ny]);
                    if (gap >= l && gap <= r) {
                        visited[nx][ny] = true;
                        queue.add(new Position(nx, ny));
                        union.add(new Position(nx, ny));
                        totalPopulation += population[nx][ny];
                    }
                }
            }
        }

        if (union.size() == 1) return false;

        int newPopulation = totalPopulation / union.size();

        for (Position pos : union) {
            population[pos.x][pos.y] = newPopulation;
        }

        return true;
    }
}

