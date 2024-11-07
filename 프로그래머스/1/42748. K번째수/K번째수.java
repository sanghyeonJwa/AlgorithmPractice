import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        // List<Integer> newList = new ArrayList<>(Arrays.asList(array));
        
        List<Integer> newList = new ArrayList<>();
        
        for(int i = 0; i < array.length; i++) {
            newList.add(array[i]);
        }
        
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            
            List<Integer> subList = new ArrayList<>();
            
            for(int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                subList.add(newList.get(j));
            }
            
            Collections.sort(subList);
            
            answer[i] = subList.get(commands[i][2] - 1);
        }
        
        return answer;
    }
}