class Solution {
    public boolean solution(int x) {
        int num = 0;
        int xCopy = x;
        
        while(xCopy > 0) {
            num += xCopy % 10;
            xCopy = xCopy / 10;
        }
        
        return x % num == 0 ? true : false;
    }
}