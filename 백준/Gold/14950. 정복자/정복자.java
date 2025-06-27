import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;

    // find 함수, x가 속한 집합의 대표를 찾는다.
    static int find(int x) {
        if(parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    // union 함수, x와 y를 같은 집합으로 묶는다.
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y)
            parent[y] = x;
    }
    
    // 간선 클래스, 두 정점과 비용을 가지고 있음.
    static class Edge implements Comparable<Edge> {
        
        int ver1, ver2, weight;
        Edge(int ver1, int ver2, int weight) {
            this.ver1 = ver1;
            this.ver2 = ver2;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 도시 수
        int m = Integer.parseInt(st.nextToken());   // 도로의 개수
        int t = Integer.parseInt(st.nextToken());   // 경계치 증가치
        
        List<Edge> edges = new ArrayList<>();
        int ver1, ver2, weight;
                
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            ver1 = Integer.parseInt(st.nextToken());
            ver2 = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(ver1, ver2, weight));
        }
        
        // 간선 가중치 기준 정렬
        Collections.sort(edges);
        
        // 부모 배열 초기화
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        int totalWeight = 0;
        int cnt = 0;
        
        for(Edge e : edges) {
            if(find(e.ver1) != find(e.ver2)) {
                union(e.ver1, e.ver2);
                totalWeight += e.weight + cnt * t;
                cnt++;
                if(cnt == n - 1) break;
            }
        }

        System.out.println(totalWeight);
    }
}
