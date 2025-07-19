

import java.util.*;
import java.io.*;

public class Main {

    static class Passenger implements Comparable<Passenger> {
        int startX, startY, destinationX, destinationY,
                dist, destinationDist;

        public Passenger(int startX, int startY, int destinationX, int destinationY) {
            this.startX = startX;
            this.startY = startY;
            this.destinationX = destinationX;
            this.destinationY = destinationY;
            this.dist = Integer.MAX_VALUE;
            this.destinationDist = Integer.MAX_VALUE;
        }

        // 택시 기준 거리 변경
        public void updateDist(int dist) {
            this.dist = dist;
        }

        // 출발지와 목적지 사이 거리 설정
        public void updateDestinationDist(int destinationDist) {
            this.destinationDist = destinationDist;
        }

        @Override
        public int compareTo(Passenger o) {
            if(this.dist != o.dist) return this.dist - o.dist;
            if(this.startX != o.startX) return this.startX - o.startX;
            return this.startY - o.startY;
        }
    }

    static List<Passenger> passengers = new ArrayList<>();
    static int n, m, fuel;
    static int taxiX, taxiY;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n =  Integer.parseInt(st.nextToken());  // 맵 크기
        m  = Integer.parseInt(st.nextToken());  // 승객 수
        fuel = Integer.parseInt(st.nextToken());    // 초기 연료 양

        map = new int[n + 1][n + 1];

        // 맵 입력 받기, 0은 빈칸, 1은 벽
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st =  new StringTokenizer(br.readLine());
        taxiX = Integer.parseInt(st.nextToken());
        taxiY = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int sX = Integer.parseInt(st.nextToken());
            int sY = Integer.parseInt(st.nextToken());
            int dX = Integer.parseInt(st.nextToken());
            int dY = Integer.parseInt(st.nextToken());
            passengers.add(new Passenger(sX, sY, dX, dY));
        }

        for(Passenger p : passengers) {

            int destDist = getPassengerDistance(p.startX, p.startY, p.destinationX, p.destinationY);

            if(destDist == -1) {
                System.out.println(-1);
                System.exit(0);
            }

            p.updateDestinationDist(destDist);
        }

        /*
        입력 처리 완료
        1. 가장 가까운 사람 찾는 bfs
        2. 목적지까지 이동하는 로직 (연료 최신화) + 운행 여부 판단
         */

        for(int i = 1; i <= m; i++) {

            // 손님 거리 계산 후, 거리별로 정렬
            updatePassengerAndTaxiDistance(taxiX, taxiY);
            Passenger p = passengers.get(0);

            if(isReachable(p)) {
                taxiDriving(p);
            }
            else {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(fuel);
    }

    static int getPassengerDistance(int startX, int startY, int destinationX, int destinationY) {
        visited = new boolean[n + 1][n + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startX, startY, 0});
        visited[startX][startY] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            int dist = curr[2];

            if(currX == destinationX && currY == destinationY) {
                return dist;
            }

            for(int i = 0; i < 4; i++) {
                int nx = currX + dx[i];
                int ny = currY + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
                if (visited[nx][ny] || map[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                q.offer(new int[] {nx, ny, dist + 1});
            }
        }

        return -1;
    }

    // 택시 현재 위치 기준으로 승객들의 거리 최신화. & 정렬
    static void updatePassengerAndTaxiDistance(int taxiX, int taxiY) {

        for (Passenger p : passengers) {
            p.updateDist(Integer.MAX_VALUE);
        }

        visited = new boolean[n + 1][n + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{taxiX, taxiY, 0});
        visited[taxiX][taxiY] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];

            for(Passenger p : passengers) {
                if(p.startX == x && p.startY == y) {
                    p.updateDist(dist);
                }
            }

            for(int i = 0; i < 4; i++) {
                int nx =  x + dx[i];
                int ny =  y + dy[i];

                if(nx < 1 || ny < 1 || nx > n || ny > n) continue;
                if(visited[nx][ny] || map[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, dist + 1});
            }
        }

        // 리스트 거리 순으로 정렬
        Collections.sort(passengers);
    }

    // 손님을 태우고 목적지까지 갈 수 있는지 확인
    static boolean isReachable(Passenger p) {
        return p.dist + p.destinationDist <= fuel;
    }

    static void taxiDriving(Passenger p) {
        fuel -= p.dist;
        fuel -= p.destinationDist;
        fuel += p.destinationDist * 2;

        taxiX = p.destinationX;
        taxiY = p.destinationY;

        passengers.remove(p);
    }
}
