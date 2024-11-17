import java.util.*;

class Solution{
    public int solution(int []A, int []B) {
        
        // 작은수는 큰수와 곱해야 전체 합이 작아진다.
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - i - 1];
        }
        
        return answer;
    }
}