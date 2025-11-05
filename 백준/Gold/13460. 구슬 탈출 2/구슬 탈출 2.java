
import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static char[][] map;
    static int rx, ry, bx, by;
    static int cnt = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 세로 크기
        m = Integer.parseInt(st.nextToken());   // 가로 크기

        map = new char[n][m];

        // 배열 입력 + 공들의 위치 추적 (전역변수)
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if (c == 'R') {
                    rx = i;
                    ry = j;
                    c = '.';
                } else if (c == 'B') {
                    bx = i;
                    by = j;
                    c = '.';
                }
                map[i][j] = c;
            }
        }

        // solve 함수로 구하기
        System.out.println(solve());
    }

    public static int solve() {
        // BFS로 최소 기울임 횟수 탐색. 상태는 (rx, ry, bx, by, depth)
        boolean[][][][] visited = new boolean[n][m][n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{rx, ry, bx, by, 0});
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int crx = cur[0], cry = cur[1], cbx = cur[2], cby = cur[3], depth = cur[4];
            cnt = Math.max(cnt, depth); // 선택사항: 진행 중 최대 깊이 기록

            if (depth >= 10) continue; // 10회를 초과하면 더 진행하지 않음

            for (int dir = 0; dir < 4; dir++) {
                int[] rMove = roll(crx, cry, dir);
                int nrx = rMove[0], nry = rMove[1], rsteps = rMove[2];
                boolean redIn = rMove[3] == 1;

                int[] bMove = roll(cbx, cby, dir);
                int nbx = bMove[0], nby = bMove[1], bsteps = bMove[2];
                boolean blueIn = bMove[3] == 1;

                // 파란 구슬이 구멍으로 들어가면 이 방향은 실패
                if (blueIn) continue;
                // 빨간만 들어가면 정답
                if (redIn) return depth + 1;

                // 같은 칸에 멈췄다면 더 많이 굴러온 구슬을 한 칸 뒤로 민다
                if (nrx == nbx && nry == nby) {
                    if (rsteps > bsteps) {
                        nrx -= dx[dir];
                        nry -= dy[dir];
                    } else {
                        nbx -= dx[dir];
                        nby -= dy[dir];
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.offer(new int[]{nrx, nry, nbx, nby, depth + 1});
                }
            }
        }
        return -1; // 10회 이내 불가능
    }

    // dir 방향으로 더 이상 움직일 수 없을 때까지 굴린다.
    // 반환: [x, y, 이동칸수, 구멍여부(1이면 구멍 진입)]
    static int[] roll(int x, int y, int dir) {
        int steps = 0;
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            char next = map[nx][ny];
            if (next == '#') break; // 벽이면 현재 위치에서 정지
            x = nx;
            y = ny;
            steps++;
            if (next == 'O') return new int[]{x, y, steps, 1};
        }
        return new int[]{x, y, steps, 0};
    }
}