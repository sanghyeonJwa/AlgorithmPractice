import java.util.*;
import java.io.*;

public class Main {

    // n,m : 지도 크기
    // x,y : 주사위 좌표
    // k : 명령 개수
    static int n, m, x, y, k;
    static int[][] map;

    // 인덱스 정의
    // 0 : top
    // 1 : north
    // 2 : east
    // 3 : west
    // 4 : south
    // 5 : bottom
    static int[] dice = new int[6];
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int commandsRead = 0;
        while (commandsRead < k) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
                continue;
            }
            int dir = Integer.parseInt(st.nextToken());
            commandsRead++;

            if (check(dir)) {
                sb.append(moveDice(dir)).append('\n');
            } else {
                continue;
            }
        }

        System.out.print(sb.toString());
    }

    // 갈 수 있는지 체크하는 함수
    public static boolean check(int dir) {
        int nX = x + dx[dir];
        int nY = y + dy[dir];
        return nX >= 0 && nX < n && nY >= 0 && nY < m;
    }

    // 주사위 움직이기 + 맵 갱신, 윗면 반환
    public static int moveDice(int dir) {

        // 위치 갱신
        x = x + dx[dir];
        y = y + dy[dir];

        // 주사위 회전
        int[] tmp = dice.clone();

        if (dir == 1) { // 동
            dice[0] = tmp[3];
            dice[2] = tmp[0];
            dice[5] = tmp[2];
            dice[3] = tmp[5];
            // north(1), south(4) 유지
            dice[1] = tmp[1];
            dice[4] = tmp[4];
        } else if (dir == 2) { // 서
            dice[0] = tmp[2];
            dice[3] = tmp[0];
            dice[5] = tmp[3];
            dice[2] = tmp[5];
            dice[1] = tmp[1];
            dice[4] = tmp[4];
        } else if (dir == 3) { // 북
            dice[0] = tmp[4];
            dice[1] = tmp[0];
            dice[5] = tmp[1];
            dice[4] = tmp[5];
            dice[2] = tmp[2];
            dice[3] = tmp[3];
        } else if (dir == 4) { // 남
            dice[0] = tmp[1];
            dice[4] = tmp[0];
            dice[5] = tmp[4];
            dice[1] = tmp[5];
            dice[2] = tmp[2];
            dice[3] = tmp[3];
        }

        // 지도와 주사위 바닥(5) 상호작용
        if (map[x][y] == 0) {
            map[x][y] = dice[5]; // 바닥에서 지도로 복사
        } else {
            dice[5] = map[x][y]; // 지도에서 바닥으로 복사
            map[x][y] = 0;
        }

        return dice[0]; // 윗면 반환
    }
}