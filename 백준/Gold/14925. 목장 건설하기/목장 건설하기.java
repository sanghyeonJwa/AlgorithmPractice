

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // M, N
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        // 땅 배열 선언
        int[][] land = new int[n][m];
        int[][] dp = new int[n][m];
        int maxSize = 0;

        // 땅 정보 입력
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기화
        for(int i = 0; i < n; i++) {
            dp[i][0] = land[i][0] == 0 ? 1 : 0;
            if (dp[i][0] == 1) maxSize = 1;
        }
        for(int j = 0; j < m; j++) {
            dp[0][j] = land[0][j] == 0 ? 1 : 0;
            if (dp[0][j] == 1) maxSize = 1;
        }


        /*
        2차원 배열내의 최대 크기의 정사각형 구하기

        dp[i][j] = dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1] 의 최소값 + 1
         */


        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {

                if(land[i][j] == 0) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }

        System.out.println(maxSize);
    }
}
