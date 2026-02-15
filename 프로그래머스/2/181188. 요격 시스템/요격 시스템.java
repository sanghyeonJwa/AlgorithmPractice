import java.util.*;

class Solution {
    
    public int solution(int[][] targets) {
     
        List<int[]> l = new ArrayList<>();
        
        for(int[] t : targets) {
            l.add(t);
        }
        
        l.sort(Comparator.comparingInt(a -> a[1]));
        
        int cnt = 0;
        int last = Integer.MIN_VALUE;
        
        for(int[] t : l) {
            if(t[0] >= last) {
                cnt++;
                last = t[1];
            }
        }
        
        return cnt;
    }
}