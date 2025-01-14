class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        
        if(board.length == 1 || board[0].length == 1) {
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    answer = Math.max(answer, board[i][j]);
                }
            }
            return answer;
        }
        
        // 정사각형의 변 길이 저장
        int[][] dp = new int[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) { // 첫 열 초기화
            dp[i][0] = board[i][0];
        }
        for (int j = 0; j < board[0].length; j++) { // 첫 행 초기화
            dp[0][j] = board[0][j];
        }
        
        for(int i = 1; i < board.length; i++) {
            for(int j = 1; j < board[0].length; j++) {
                
                if(board[i][j] == 1)
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                else
                    dp[i][j] = 0;
               
                if(dp[i][j] > answer)
                    answer = dp[i][j];
            }
        }
        
        return answer * answer;
    }
}