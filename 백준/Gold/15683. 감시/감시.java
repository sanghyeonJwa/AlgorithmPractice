import java.util.*;
import java.io.*;

public class Main {

    /*
    G3-15683 : 감시
     */

    static int N, M;
    static int[][] map;
    static List<int[]> cctvs = new ArrayList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;

    static final int[][][] DIRS = {
            {},
            { {0}, {1}, {2}, {3} },                 // 1번
            { {0, 2}, {1, 3} },                     // 2번
            { {2, 1}, {1, 0}, {0, 3}, {3, 2} },     // 3번 (상우, 우하, 하좌, 좌상)
            { {3, 2, 1}, {2, 1, 0}, {1, 0, 3}, {0, 3, 2} }, // 4번 (3방향)
            { {0, 1, 2, 3} }                        // 5번
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvs.add(new int[]{i, j, map[i][j]}); // coordinate + type
                }
            }
        }

        dfs(0, map);
        System.out.println(answer);
    }

    private static void dfs(int depth, int[][] curMap) {

        if(depth == cctvs.size()) {
            answer = Math.min(answer, countBlindSpot(curMap));
            return;
        }

        int[] cctv = cctvs.get(depth);
        int x = cctv[0];
        int y = cctv[1];
        int type = cctv[2];

        for (int[] dirs : DIRS[type]) {
            int[][] next = copyMap(curMap);
            // 선택한 방향 조합대로 감시 칠하기
            for (int d : dirs) {
                watch(next, x, y, d);
            }
            dfs(depth + 1, next);
        }
    }

    static void watch(int[][] m, int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while (0 <= nx && nx < N && 0 <= ny && ny < M) {
            if (m[nx][ny] == 6) return; // 벽이면 stop

            if (m[nx][ny] == 0) {
                m[nx][ny] = -1; // 감시됨 표시
            }
            // CCTV(1~5)나 이미 감시(-1)는 그냥 통과
            nx += dx[dir];
            ny += dy[dir];
        }
    }

    static int[][] copyMap(int[][] src) {
        int[][] dst = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(src[i], 0, dst[i], 0, M);
        }
        return dst;
    }

    private static int countBlindSpot(int[][] curMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (curMap[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}