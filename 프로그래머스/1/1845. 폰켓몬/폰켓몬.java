import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        HashSet<Integer> hset = new HashSet<>();
        
        for(int number : nums) {
            hset.add(number);
        }
        
        int maxCount = nums.length / 2;
        
        return Math.min(hset.size(), maxCount);
    }
}