import java.util.*;
import java.io.*;

public class Main {

    static long[][] dp;
    static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        반드시 오른쪽 아니면 아래로만
         */

        // 게임판 크기 입력
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];
        dp[0][0] = 1;

        // 게임판 입력
        for(int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int x = 0; x < N; x++) {
            for(int y = 0; y < N; y++) {
                if(dp[x][y] == 0 || (y == N - 1 && x == N - 1))
                    continue;

                int weight = map[x][y];

                if(x + weight < N)
                    dp[x + weight][y] += dp[x][y];

                if(y + weight < N)
                    dp[x][y + weight] += dp[x][y];
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}
