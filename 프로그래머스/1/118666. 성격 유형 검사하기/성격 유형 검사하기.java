import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        // 일단 map을 하나 만들자 : 유형 + 숫자
        
        Map<Character, Integer> mbti = new HashMap<>();
        char[] mbtiChar = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        String answer = "";
         
        for(int i = 0; i < survey.length; i++) {
            
            char str1 = survey[i].charAt(0);
            char str2 = survey[i].charAt(1);
            
            int point = choices[i];
            
            if(point <= 3)
                mbti.put(str1, mbti.getOrDefault(str1, 0) + 4 - point);
            
            if(point >= 5)
                mbti.put(str2, mbti.getOrDefault(str2, 0) + point - 4);
        }
        
        for(int i = 0; i < mbtiChar.length; i += 2) {
            int charWeight1 = mbti.getOrDefault(mbtiChar[i], 0);
            int charWeight2 = mbti.getOrDefault(mbtiChar[i + 1], 0);
            
            if(charWeight1 > charWeight2 || charWeight1 == charWeight2)
                answer += mbtiChar[i];
            else
                answer += mbtiChar[i + 1];
        }
        
        return answer;
    }
}