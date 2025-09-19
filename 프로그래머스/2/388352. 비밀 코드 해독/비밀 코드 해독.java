class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        
        /*
        n : 정수 범위
        q[i] : 입력 정수
        ans[i] : q[i] 에서 몇개의 정답이 있는지
        */
        
        int m = q.length; // 시도 횟수
        
        boolean[] check = new boolean[n + 1];
        
        for(int i = 0; i < m; i++) {
            if(ans[i] == 0)
                for(int t : q[i]) 
                    check[t] = true;
        }
        
        int[] cand = new int[n];
        int cnt = 0;
    
        for(int i = 1; i <= n; i++) {
            if(!check[i]) cand[cnt++] = i;
        }
        if(cnt < 5) return 0;
        
        int[] comb = new int[5];
        Counter counter = new Counter();
        backtrack(0, 0, cand, cnt, comb, q, ans, counter, n);
        
        return counter.count;
    }
    
    private void backtrack(int depth, int start, int[] cand, int cnt, int[] comb,
                           int[][] q, int[] ans, Counter counter, int n) {
        if (depth == 5) {
            boolean[] present = new boolean[n + 1];
            for (int i = 0; i < 5; i++) present[comb[i]] = true;

            if (isValidByBoolPresent(present, q, ans)) {
                counter.count++;
            }
            return;
        }
        for (int i = start; i <= cnt - (5 - depth); i++) {
            comb[depth] = cand[i];
            backtrack(depth + 1, i + 1, cand, cnt, comb, q, ans, counter, n);
        }
    }

    private boolean isValidByBoolPresent(boolean[] present, int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int match = 0;
            for (int v : q[i]) {
                if (present[v]) match++;
            }
            if (match != ans[i]) return false;
        }
        return true;
    }

    static class Counter {
        int count = 0;
    }
}