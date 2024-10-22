class Solution {
    public int solution(int a, int b) {
        String aString = String.valueOf(a);
        String bString = String.valueOf(b);
        
        int case1 = Integer.parseInt(aString + bString);
        int case2 = Integer.parseInt(bString + aString);
        
        return case1 > case2 ? case1 : case2;
    }
}