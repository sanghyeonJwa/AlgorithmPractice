import java.util.*;
import java.io.*;

public class Main {

    static int n, m, k;
    static int[][] map; // 현재 양분
    static int[][] a;   // 겨울에 추가될 양분
    static Deque<Integer>[][] dq; // 각 칸의 나무 (나이 오름차순)

    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        a = new int[n][n];
        dq = new ArrayDeque[n][n];

        // 초기 세팅
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                dq[i][j] = new ArrayDeque<>();
                map[i][j] = 5;
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 나무 입력 (나이 기준 정렬)
        List<int[]> temp = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            temp.add(new int[]{x, y, age});
        }

        temp.sort((o1, o2) -> o1[2] - o2[2]);

        for (int[] t : temp) {
            dq[t[0]][t[1]].addLast(t[2]);
        }

        // K년 반복
        for(int year = 0; year < k; year++) {
            spring();
            fall();
            winter();
        }

        // 결과 계산
        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                result += dq[i][j].size();
            }
        }

        System.out.println(result);
    }

    // 어린 나무부터 양분 섭취, 못 먹으면 죽고 양분으로 변환
    static void spring() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if(dq[i][j].isEmpty()) continue;

                Deque<Integer> newDq = new ArrayDeque<>();
                int dead = 0;

                while(!dq[i][j].isEmpty()) {
                    int age = dq[i][j].pollFirst();

                    if(map[i][j] >= age) {
                        map[i][j] -= age;
                        newDq.addLast(age + 1);
                    } else {
                        dead += age / 2;
                    }
                }

                map[i][j] += dead;
                dq[i][j] = newDq;
            }
        }
    }

    // 나이가 5의 배수인 나무가 주변 8칸에 번식
    static void fall() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if(dq[i][j].isEmpty()) continue;

                for(int age : dq[i][j]) {
                    if(age % 5 == 0) {
                        for(int d = 0; d < 8; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];

                            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                            dq[nx][ny].addFirst(1);
                        }
                    }
                }
            }
        }
    }

    // 양분 추가
    static void winter() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] += a[i][j];
            }
        }
    }
}