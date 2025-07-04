import java.util.*;
import java.io.*;

public class Main {

    static List<List<Integer>> tree = new ArrayList<>();
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 정점 개수

        for(int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree.get(x).add(y);
            tree.get(y).add(x);
        }

        /*
        자신과 연결된 모든 노드가 얼리어답터여야만 한다.
        얼리어답터의 최소 수를 구해야 한다.
        트리는 루트 노드 제외 부모가 1개이다.
        부모가 얼리어답터면 자식은 얼리어답터 or 일반인
        부모가 일반인이면 자식은 무조건 얼리어답터여야 함.
         */

        //[][0] : 얼리어답터 , [][1] : 일반인
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    public static void dfs(int startNode) {
        visited[startNode] = true;
        dp[startNode][0] = 1;
        dp[startNode][1] = 0;

        for(int child : tree.get(startNode)) {
            if(!visited[child]) {
                dfs(child);
                dp[startNode][0] += Math.min(dp[child][0], dp[child][1]);
                dp[startNode][1] += dp[child][0];
            }
        }
    }
}
