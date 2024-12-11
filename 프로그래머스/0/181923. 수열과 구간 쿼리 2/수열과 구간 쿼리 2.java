import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        int[] answers = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++) {
            
            int answer = -1;
            int[] newArr = Arrays.copyOfRange(arr, queries[i][0], queries[i][1] + 1);
            
            Arrays.sort(newArr);
            
            for(int numbers : newArr) {
                if(numbers > queries[i][2]) {
                    answer = numbers;
                    break;
                }
            }
            answers[i] = answer;
        }
        
        return answers;
    }
}