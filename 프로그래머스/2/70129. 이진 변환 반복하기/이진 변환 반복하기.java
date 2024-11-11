public class Solution {
    public int[] solution(String s) {
        int transformCount = 0;
        int zeroCount = 0;
        
        while (!s.equals("1")) {
            int currentLength = s.length();
            s = s.replace("0", "");
            int onesCount = s.length();
            
            zeroCount += (currentLength - onesCount);
            s = Integer.toBinaryString(onesCount);
            transformCount++;
        }
        
        return new int[]{transformCount, zeroCount};
    }
}
