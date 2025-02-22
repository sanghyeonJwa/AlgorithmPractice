
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 사람 수
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]); // 시작 사람
        int y = Integer.parseInt(input[1]); // 목표 사람
        int m = Integer.parseInt(br.readLine()); // 관계 개수

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] relation = br.readLine().split(" ");
            int a = Integer.parseInt(relation[0]);
            int b = Integer.parseInt(relation[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.println(bfs(n, x, y, graph));
    }

    private static int bfs(int n, int start, int target, List<List<Integer>> graph) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];  // 사람
            int depth = cur[1]; // 촌수

            if (node == target) {
                return depth;
            }

            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, depth + 1});
                }
            }
        }
        return -1;

    }
}
