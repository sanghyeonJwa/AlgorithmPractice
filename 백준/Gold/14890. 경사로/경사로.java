import java.util.*;
import java.io.*;

public class Main {

    static int n, l;
    static int[][] map;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 맵 크기
        l = Integer.parseInt(st.nextToken());   // 경사로 길이

        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {

            int[] line1 = new int[n];   // 가로
            int[] line2 = new int[n];   // 세로

            for(int j = 0; j < n; j++) {
                line1[j] = map[i][j];
                line2[j] = map[j][i];
            }

            if(checkPass(line1)) cnt++;
            if(checkPass(line2)) cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean checkPass(int[] line) {

        boolean[] used = new boolean[n];
        for(int i = 0; i < n - 1; i++) {

            int cur = line[i];
            int next = line[i + 1];
            int diff = cur - next;

            if(diff == 0) continue;

            if(diff != 1 && diff != -1) return false;

            if(diff == -1) {
                for (int k = i; k > i - l; k--) {
                    if (k < 0) return false;
                    if (line[k] != cur) return false;
                    if (used[k]) return false;
                }
                for (int k = i; k > i - l; k--) used[k] = true;
            }

            if(diff == 1) {
                for (int k = i + 1; k <= i + l; k++) {
                    if (k >= n) return false;
                    if (line[k] != next) return false;
                    if (used[k]) return false;
                }
                for (int k = i + 1; k <= i + l; k++) used[k] = true;

                i = i + l - 1;
            }
        }

        return true;
    }
}