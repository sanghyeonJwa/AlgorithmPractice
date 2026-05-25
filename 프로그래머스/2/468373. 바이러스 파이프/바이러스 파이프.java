import java.util.*;

class Solution {

    static class Edge {
        int to;
        int type;

        Edge(int to, int type) {
            this.to = to;
            this.type = type;
        }
    }

    static List<Edge>[] graph;
    static int answer;
    static int n;
    static int k;

    public int solution(int n, int infection, int[][] edges, int k) {

        this.n = n;
        this.k = k;

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {

            int a = edge[0];
            int b = edge[1];
            int type = edge[2];

            graph[a].add(new Edge(b, type));
            graph[b].add(new Edge(a, type));
        }

        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;

        answer = 1;

        dfs(0, infected);

        return answer;
    }

    static void dfs(int depth, boolean[] infected) {

        answer = Math.max(answer, count(infected));

        if (depth == k) {
            return;
        }

        for (int type = 1; type <= 3; type++) {

            boolean[] next = infected.clone();

            spread(next, type);

            dfs(depth + 1, next);
        }
    }

    static void spread(boolean[] infected, int type) {

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (infected[i]) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {

            int now = queue.poll();

            for (Edge next : graph[now]) {

                if (next.type != type) {
                    continue;
                }

                if (infected[next.to]) {
                    continue;
                }

                infected[next.to] = true;
                queue.offer(next.to);
            }
        }
    }

    static int count(boolean[] infected) {

        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (infected[i]) {
                cnt++;
            }
        }

        return cnt;
    }
}