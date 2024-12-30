import java.util.*;

public class Solution {
    public int solution(int n) {
        
//         int[] dp = new int[n + 1];
//         dp[1] = 1;
        
//         for(int i = 2; i <= n; i++) {
            
//             dp[i] = i % 2 == 0 ? dp[i / 2] : dp[i - 1] + 1;
//         }
        
//         return dp[n];
        
        int count = 0;

        while (n > 0) {
            if (n % 2 == 1) {
                count++;
                n--;
            } 
            n /= 2;
        }

        return count;
    }
}