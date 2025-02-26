import java.util.*;
import java.io.*;

public class Main {

    // 상어 내부 클래스
    public static class Shark {
        int sharkSize, sharkX, sharkY, eatenFish;

        public Shark(int sharkX, int sharkY) {
            this.sharkX = sharkX;
            this.sharkY = sharkY;
            this.sharkSize = 2;
            this.eatenFish = 0;
        }

        public void eat() {
            eatenFish++;
            if(eatenFish == sharkSize) {
                sharkSize++;
                eatenFish = 0;
            }
        }
    }

    public static int N;        // 영역 크기
    public static int[][] area; // 영역
    public static Shark babyShark;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());    // 영역 크기
        area = new int[N][N];                   // 영역

        // 영역 입력
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreTokens()){
                area[i][j] = Integer.parseInt(st.nextToken());

                // 상어 초기 위치 저장
                if(area[i][j] == 9) {
                    babyShark = new Shark(i, j);
                    area[i][j] = 0;
                }
                j++;
            }
        }

        System.out.println(sharkMethod());
    }

    public static int sharkMethod() {
        int second = 0;

        while(true) {
            int[] target = nextTarget();
            if(target == null) break;

            babyShark.sharkX = target[0];
            babyShark.sharkY = target[1];

            babyShark.eat();
            area[babyShark.sharkX][babyShark.sharkY] = 0;

            second += target[2];
        }

        return second;
    }

    public static int[] nextTarget() {

        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        int[] result = new int[2];

        q.add(new int[]{babyShark.sharkX, babyShark.sharkY, 0});
        visited[babyShark.sharkX][babyShark.sharkY] = true;

        List<int[]> fishList = new ArrayList<>();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];


            for(int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY]) {
                    if(area[nextX][nextY] <= babyShark.sharkSize) {
                        visited[nextX][nextY] = true;
                        q.add(new int[]{nextX, nextY, distance + 1});

                        if(area[nextX][nextY] != 0 && area[nextX][nextY] < babyShark.sharkSize) {
                            fishList.add(new int[]{nextX, nextY, distance + 1});
                        }
                    }
                }
            }
        }

        if(fishList.isEmpty()) return null;

        fishList.sort((a, b) -> {
            if (a[2] == b[2]) {                         // 거리 같으면
                if (a[0] == b[0]) return a[1] - b[1];   // y 좌표 작은 순
                return a[0] - b[0];                     // x 좌표 작은 순
            }
            return a[2] - b[2];                         // 거리 짧은 순
        });

        return fishList.get(0);
    }
}
