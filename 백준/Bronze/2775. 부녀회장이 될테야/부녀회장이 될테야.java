import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        List<Integer> results = new ArrayList<>();

        for(int i = 0; i < testCase; i++) {

            int k = Integer.parseInt(br.readLine());    // 층
            int n = Integer.parseInt(br.readLine());    // 호수

            /*
            “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다”
             */

            int[][] dp = new int[k + 1][n + 1]; // 인원수

            for(int j = 1; j <= n; j++) {
                dp[0][j] = j;
            }

            for (int a = 1; a <= k; a++) {
                for (int b = 1; b <= n; b++) {
                    dp[a][b] = dp[a - 1][b] + dp[a][b - 1];
                }
            }
            results.add(dp[k][n]);
        }

        for(int result : results) {
            System.out.println(result);
        }
    }
}
