import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> st = new Stack<>();
        
        for(int number : arr) {
            if(st.isEmpty() || st.peek() != number)
                st.push(number);
        }
        
        int[] answer = new int[st.size()];
        
        for(int i = 0; i < st.size(); i++) {
            answer[i] = st.get(i);
        }

        return answer;
    }
}