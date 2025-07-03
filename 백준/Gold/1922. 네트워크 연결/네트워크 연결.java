import java.util.*;
import java.io.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int v1, v2, weight;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int[] parent;
    static List<Edge> edges = new ArrayList<>();

    static int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        int p1 = find(x), p2 = find(y);
        if(p1 != p2)
            parent[p2] = p1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n =  Integer.parseInt(br.readLine()); // 컴퓨터 수
        int m =  Integer.parseInt(br.readLine()); // 선의 수

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(v1, v2, weight));
        }

        Collections.sort(edges);

        int totalCost = 0, cnt = 0;

        for(Edge e : edges) {
            if(find(e.v1) != find(e.v2)) {
                union(e.v1, e.v2);
                totalCost += e.weight;
                cnt++;

                if(cnt == n - 1) break;
            }
        }

        System.out.println(totalCost);
    }
}
