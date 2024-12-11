import java.util.*;
import java.io.*;


class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {
            
            if(map.containsKey(clothes[i][1]))
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            else
                map.put(clothes[i][1], 1);
        }
        
        int result = 1;
        
        for(String key : map.keySet()) {
            result *= map.get(key) + 1;
        }
        
        return result - 1;
    }
}