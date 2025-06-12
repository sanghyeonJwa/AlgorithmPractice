import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        /*
        두 큐에 합을 비교해서 작은쪽에서 큰 쪽으로 옮기기
        */
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        int num;
        
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        long total = sum1 + sum2;
        
        if(total % 2 != 0) return -1;
        long half = total / 2;
        
        int limit = queue1.length * 4;
        int operationCnt = 0;
        
        while(operationCnt <= limit) {
            if(sum1 == sum2) return operationCnt;
            
            if(sum1 > sum2) {
                num = q1.poll();
                sum1 -= num;
                q2.add(num);
                sum2 += num;
            }
            else {
                num = q2.poll();
                sum2 -= num;
                q1.add(num);
                sum1 += num;
            }
            
            operationCnt++;
        }
        
        return -1;
    }
}