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

        public void updateDist(int dist) {
            this.dist = dist;
        }

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
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n =  Integer.parseInt(st.nextToken());
        m  = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];

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
            // 공통 BFS를 활용해 출발지와 목적지 거리 계산
            int destDist = bfs(p.startX, p.startY)[p.destinationX][p.destinationY];

            if(destDist == -1) {
                System.out.println(-1);
                return;
            }

            p.updateDestinationDist(destDist);
        }

        for(int i = 1; i <= m; i++) {

            // 공통 BFS로 손님 거리 계산 및 정렬
            updatePassengerAndTaxiDistance(taxiX, taxiY);

            // 첫 번째 손님을 리스트에서 제거하면서 선택
            Passenger p = passengers.remove(0);

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

    // 공통 BFS 함수: 시작 위치 기준으로 맵 전체 거리 계산
    static int[][] bfs(int startX, int startY) {
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        dist[startX][startY] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
                if (dist[nx][ny] != -1 || map[nx][ny] == 1) continue;

                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        return dist;
    }

    static void updatePassengerAndTaxiDistance(int taxiX, int taxiY) {
        int[][] dist = bfs(taxiX, taxiY);

        for (Passenger p : passengers) {
            if (dist[p.startX][p.startY] != -1) {
                p.updateDist(dist[p.startX][p.startY]);
            } else {
                p.updateDist(Integer.MAX_VALUE);
            }
        }

        Collections.sort(passengers);
    }

    static boolean isReachable(Passenger p) {
        return p.dist + p.destinationDist <= fuel;
    }

    static void taxiDriving(Passenger p) {
        fuel -= p.dist;
        fuel -= p.destinationDist;
        fuel += p.destinationDist * 2;

        taxiX = p.destinationX;
        taxiY = p.destinationY;
    }
}