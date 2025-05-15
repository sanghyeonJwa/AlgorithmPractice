import java.util.*;
import java.io.*;

public class Main {

    static int n, m, r, c, d;
    static int[][] room;    // 0 -> 청소 x , 1 -> 벽, 2 -> 청소 완료
    static int cnt = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 방 크기 입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()); // 로봇 i
        c = Integer.parseInt(st.nextToken()); // 로봇 j
        d = Integer.parseInt(st.nextToken()); // 방향 (0 = 12시, 1 = 3시, 2 = 6시, 3 = 9시)

        room = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleaning();
        System.out.println(cnt);
    }

    public static void cleaning() {

        while(true) {
            // 1. 현재 자리 청소하기
            if(room[r][c] == 0) {
                room[r][c] = 2;
                cnt++;
            }

            // 2. 4방면에 치워야 할 공간 있다면
            if(scan()) {
                while(true) {
                    d = d - 1 < 0 ? d - 1 + 4 : d - 1;
                    if(room[r + dx[d]][c + dy[d]] == 0) {
                        r += dx[d];
                        c += dy[d];
                        break;
                    }
                }
            }
            // 3. 4방면에 치워야 할 공간 없다면
            else {
                if(room[r - dx[d]][c - dy[d]] != 1) {
                    r -= dx[d];
                    c -= dy[d];
                }
                else {
                    break;
                }
            }
        }
    }

    // 4방면에 청소해야 할 공간이 있는지 확인
    public static boolean scan() {

        for(int i = 0; i < 4; i++) {

            int nx = r + dx[i];
            int ny = c + dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] == 0) {
                return true;
            }
        }

        return false;
    }
}

