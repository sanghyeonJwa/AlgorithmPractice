import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        Set<String> stringSet = new HashSet<>();
        
        int[] result = {0, 0};
        
        stringSet.add(words[0]);
        String lastWord = words[0];
        
        for(int i = 1; i < words.length; i++) {
            
            char lastAlphabet = lastWord.charAt(lastWord.length() - 1);
            
            if(stringSet.contains(words[i]) || words[i].charAt(0) != lastAlphabet) {
                result[0] = i % n + 1;
                result[1] = i / n + 1;
                return result;
            }
            
            lastWord = words[i];
            stringSet.add(lastWord);
        }
    
        return result;
    }
}