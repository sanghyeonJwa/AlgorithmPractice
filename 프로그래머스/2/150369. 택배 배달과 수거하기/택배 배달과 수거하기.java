class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliver = 0, pickup = 0;
        
        /*
        cap : 재활용 택배 상자 최대 수
        n : 배달할 집의 개수
        deliveries : 배달할 택배 상자의 개수
        pickups :수거할 택배 상자의 개수
        
        무조건 먼 곳 부터 처리하는게 맞음.
        최대한 많이 들고가서 내려 놓는다고 생각해보기
        */
        
        for(int i = n - 1; i >= 0; i--) {
            deliver += deliveries[i];
            pickup += pickups[i];
            
            // 작업이 남아있는 경우
            // 위에서 더했는데도 음수라는 말은 전 집에서 왕복한 횟수에서 처리가 가능하다는 의미
            while(deliver > 0 || pickup > 0) {
                deliver -= cap;
                pickup -= cap;
                answer += (long) ((i + 1) * 2);
            }
        }
        
        
        return answer;
    }
}