class Solution {
    public String solution(String code) {
        String answer = "";
        char mode = '0';
        
        char[] charArray = code.toCharArray();
        
        for(int i = 0; i < charArray.length; i++) {
            if(charArray[i] == '1') {
                mode = mode == '0'? '1' : '0';
            }
            else {
                if(mode == '0' && i % 2 == 0)
                    answer += charArray[i];
                else if(mode == '1' && i % 2 != 0)
                    answer += charArray[i];
            }
        }
        
        if(answer == "")
            answer = "EMPTY";
        
        return answer;
    }
}