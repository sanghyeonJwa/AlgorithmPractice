

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 동기의 수 (노드 수)
        int M = Integer.parseInt(br.readLine()); // 친구 관계 수 (간선 수)

        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            graph[B].add(A);
        }

        System.out.println(countInvitedFriends(graph, N));
    }

    public static int countInvitedFriends(List<Integer>[] graph, int N) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int[] depth = new int[N + 1];

        queue.add(1); // 상근이(1번 노드)부터 시작
        visited[1] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    depth[next] = depth[now] + 1;
                    if (depth[next] <= 2) count++; // 친구와 친구의 친구만 초대 가능
                    queue.add(next);
                }
            }
        }

        return count;
    }
}
