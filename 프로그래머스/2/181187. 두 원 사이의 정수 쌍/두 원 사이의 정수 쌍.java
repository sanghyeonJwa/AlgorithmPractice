class Solution {
    public long solution(int r1, int r2) {
        
        /*
        원점에서 점까지의 거리가 작은 반지름보단 크거나 같고, 큰 반지름 보단 작거나 같으면 된다.
        점의 맥시멈은 r2 만큼의 사각형이다.
        */
        
        long answer = 0;
        
        long r1sq = (long) r1 * r1;
        long r2sq = (long) r2 * r2;
        
        for(long x = 1; x <= r2; x++) {
            
            long xsq = x * x;
            
            long yMax =  (long) Math.sqrt(r2sq - xsq);
            long yMin = 0;
            
            if(xsq < r1sq) {
                yMin = (long) Math.ceil(Math.sqrt(r1sq - xsq));
            }
            
            answer += (yMax - yMin + 1);
        }
        
        return answer * 4;
    }
}