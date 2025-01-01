import java.util.*;
import java.io.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        // 경로의 개수
        int[][] dp = new int[n + 1][m + 1];
        
        for(int[] array : dp) {
            Arrays.fill(array, 0);
        }
        
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        
        dp[1][1] = 1;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                
                if (i > 1) {
                    dp[i][j] += dp[i - 1][j];
                }

                if (j > 1) {
                    dp[i][j] += dp[i][j - 1];
                }

                dp[i][j] %= 1_000_000_007;
            }
        }
        
        return dp[n][m];
    }
}