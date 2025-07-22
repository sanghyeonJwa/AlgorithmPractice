import java.util.*;
import java.io.*;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static int[] graphCnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 총 문제 수
        int m = Integer.parseInt(st.nextToken());   // 먼저 풀면 좋은 문제 수

        graphCnt = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken()); // 먼저 풀어야 하는 문제
            int post = Integer.parseInt(st.nextToken()); // 그 후 문제

            graph.get(pre).add(post);
            graphCnt[post]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 진입 차수 0인 문제들 우선순위 큐에 넣기
        for(int i = 1; i <= n; i++) {
            if(graphCnt[i] == 0) {
                pq.add(i);
            }
        }

        // 위상 정렬 수행
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int now = pq.poll();  // 현재 푸는 문제
            sb.append(now).append(" ");

            for(int next : graph.get(now)) {
                graphCnt[next]--;
                if(graphCnt[next] == 0) {
                    pq.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}