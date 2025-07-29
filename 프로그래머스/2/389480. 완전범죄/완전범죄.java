import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(int[][] info, int n, int m) {
        
        int size = info.length;
        int[][] dp = new int[size + 1][m];
        
        for (int i = 0; i <= size; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        // 아무것도 훔치지 않았을 떄,
        dp[0][0] = 0;
        
        for (int i = 1; i <= size; i++) {
            int a = info[i - 1][0];
            int b = info[i - 1][1];

            for (int j = 0; j < m; j++) {
                // A가 i번째 물건을 훔친 경우
                if (dp[i - 1][j] != Integer.MAX_VALUE && dp[i - 1][j] + a < dp[i][j]) {
                    dp[i][j] = dp[i - 1][j] + a;
                }

                // B가 i번째 물건을 훔친 경우
                if (j + b < m && dp[i - 1][j] != Integer.MAX_VALUE && dp[i - 1][j] < dp[i][j + b]) {
                    dp[i][j + b] = dp[i - 1][j];
                }
            }
        }

        // 정답 계산: b 흔적이 m 미만인 상태에서 최소 a 흔적
        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            answer = Math.min(answer, dp[size][j]);
        }

        return answer >= n ? -1 : answer;

    }
}