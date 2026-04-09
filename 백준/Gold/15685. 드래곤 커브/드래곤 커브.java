import java.util.*;
import java.io.*;

public class Main {


    static boolean[][] map = new boolean[101][101];
    static int n;
    static int x,y,d,g;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            curve(x, y, d, g);
        }

        System.out.println(countSquare());
    }

    private static void curve(int x, int y, int d, int g) {

        List<Integer> directions = new ArrayList<>();
        directions.add(d);

        for (int i = 0; i < g; i++) {
            for (int j = directions.size() - 1; j >= 0; j--) {
                directions.add((directions.get(j) + 1) % 4);
            }
        }

        map[y][x] = true;

        for (int dir : directions) {
            x += dx[dir];
            y += dy[dir];

            if (x >= 0 && x <= 100 && y >= 0 && y <= 100) {
                map[y][x] = true;
            }
        }
    }


    static int countSquare() {
        int count = 0;

        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 100; x++) {
                if (map[y][x] && map[y][x + 1]
                        && map[y + 1][x] && map[y + 1][x + 1]) {
                    count++;
                }
            }
        }

        return count;
    }
}