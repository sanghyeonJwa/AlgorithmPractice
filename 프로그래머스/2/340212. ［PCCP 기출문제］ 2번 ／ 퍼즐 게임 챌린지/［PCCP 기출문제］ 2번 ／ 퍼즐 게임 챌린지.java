import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int n = diffs.length;
        int right = 0;
        int left = 1;
        for(int level : diffs) right = Math.max(right, level);
        
        int answer = right;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long need = calculateTime(diffs, times, mid, limit);
            if (need <= limit) {
                answer = mid;      
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    public long calculateTime(int[] diffs, int[] times, int level, long limit) {
        long total = 0L;
        int missCnt = 0;
        int prev = 0;
        int cur = 0;
        
        for(int i = 0; i < diffs.length; i++) {
            if(diffs[i] <= level)
                total += times[i];
            else {
                missCnt = diffs[i] - level;
                prev = (i == 0) ? 0 : times[i - 1];
                cur = times[i];
                
                total += (long) missCnt * (prev + cur) + cur;
            }
            
            if(total > limit)
                return total;
        }
        
        return total;
    }
}