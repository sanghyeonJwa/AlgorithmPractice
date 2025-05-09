import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 한줄에 사자가 있는 경우의 수 3가지 -> 1. 왼쪽, 2. 오른쪽, 3. 없다
        int[][] dp = new int[N + 1][3];

        dp[1][0] = 1;   // 왼쪽
        dp[1][1] = 1;   // 오른쪽
        dp[1][2] = 1;   // 없음

        for(int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
        }

        int result = (dp[N][0] + dp[N][1] + dp[N][2]) % 9901;

        System.out.println(result);
    }
}

