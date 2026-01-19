import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] map;
    static boolean[] startTeam;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        startTeam = new boolean[n];
        startTeam[0] = true;

        dfs(1, 1);
        System.out.println(answer);
    }

    public static void dfs(int index, int cnt) {

        if(cnt == n / 2) {
            answer = Math.min(answer, calDiff());
            return;
        }

        if(index >= n) return;
        if (cnt + (n - index) < n / 2) return;

        for (int i = index; i < n; i++) {
            startTeam[i] = true;
            dfs(i + 1, cnt + 1);
            startTeam[i] = false;
        }
    }

    public static int calDiff() {
        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (startTeam[i] && startTeam[j]) {
                    startSum += map[i][j] + map[j][i];
                } else if (!startTeam[i] && !startTeam[j]) {
                    linkSum += map[i][j] + map[j][i];
                }
            }
        }
        return Math.abs(startSum - linkSum);
    }
}