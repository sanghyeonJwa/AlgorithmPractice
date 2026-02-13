import java.util.*;
import java.io.*;

public class Main {

    /*
    14502. 연구소
     */

    // 0 : 빈 곳, 1 : 벽, 2 : 바이러스
    static int[][] map;
    static int[][] temp;
    static int n, m;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*
        안전 영역이 최대야 한다.
        0을 3개 고르고 벽 세운 후, 역병 퍼지게 하기. -> 빈칸 세기
         */

        selectWall(0);
        System.out.println(max);
    }

    static void selectWall(int count) {

        if(count == 3) {
            spreadVirus();
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    selectWall(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void spreadVirus() {
        temp = new int[n][m];

        for(int i = 0; i < n; i++) {
            temp[i] = map[i].clone();
        }

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(temp[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && temp[nx][ny] == 0) {
                        temp[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                }
            }
        }

        checkSafeZone(temp);
    }

    private static void checkSafeZone(int[][] tempMap) {

        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(tempMap[i][j] == 0) cnt++;
            }
        }

        max = Math.max(max, cnt);
    }
}