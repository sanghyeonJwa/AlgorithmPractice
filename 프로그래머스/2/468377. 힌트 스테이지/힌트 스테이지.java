import java.util.*;

class Solution {
    public int solution(int[][] cost, int[][] hint) {
        
        int n = cost.length;
        int answer = Integer.MAX_VALUE;
        
        for(int mask = 0; mask < (1 << (n - 1)); mask++) {
            int cnt[] = new int[n + 1]; // 해당 스테이지에서 사용할 힌트 개수
            int total = 0;
            
            for(int stage = 1; stage <= n; stage++) {
                total += cost[stage - 1][cnt[stage]];
                if (stage == n) continue;
                
                // 해당 스테이지에서 힌트 번들 구매 경우
                if((mask & (1 << (stage - 1))) != 0) {
                    total += hint[stage - 1][0];
                    
                    for(int i = 1; i < hint[stage - 1].length; i++) {
                        int target = hint[stage - 1][i];
                        
                        if(cnt[target] < n - 1) cnt[target]++;
                    }
                }
            }
            answer = Math.min(answer, total);
        }
        
        return answer;
    }
}