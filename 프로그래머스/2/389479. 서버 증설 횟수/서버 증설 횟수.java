import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int server = 0;
        int serverNeeds = 0;
        int requiredServer = 0;
        int[] serverTimer = new int[players.length];
        
        /* 서버 유지시간 : k 시간 , 이용자 커트라인 : m 명 */
        
        for(int i = 0; i < players.length; i++) {
            
            requiredServer = players[i] / m;
            
            if(requiredServer > server) {
                
                // 현재 필요한 서버 양
                serverNeeds = requiredServer - server;
                
                server += serverNeeds;  // 서버 증설
                answer += serverNeeds;  // 증가량 answer에 반영
                serverTimer[i] = serverNeeds;   // 타이머 관리
            }
            
            if(i >= k - 1) {
                server -= serverTimer[i - k + 1];
            }     
        }
        
        return answer;
    }
}