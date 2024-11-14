import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> hMap = new HashMap<>();
        String answer = "";
        
        for(String names : participant) {
            hMap.put(names, hMap.getOrDefault(names, 0) + 1);
        }
        
        for(String names : completion) {
            hMap.put(names, hMap.get(names) - 1);
        }
        
        for(String names : hMap.keySet()) {
            if(hMap.get(names) != 0) {
                answer = names;
            }
        }
        
        
        return answer;
    }
}