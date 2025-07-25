import java.util.*;
import java.io.*;

public class Main {

    static class Planet {
        int index;
        int x, y, z;

        public Planet(int index, int x, int y, int z) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static int[] parent;

    static int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int x, int y) {
        int rootA = find(x);
        int rootB = find(y);
        if (rootA == rootB) return false;
        parent[rootB] = rootA;
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Planet[] planets = new Planet[n];
        List<Edge> edges = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(i, x, y, z);
        }

        for (int d = 0; d < 3; d++) {
            int dim = d;
            Arrays.sort(planets, (a, b) -> {
                if (dim == 0) return Integer.compare(a.x, b.x);
                else if (dim == 1) return Integer.compare(a.y, b.y);
                else return Integer.compare(a.z, b.z);
            });

            for (int i = 0; i < n - 1; i++) {
                Planet p1 = planets[i];
                Planet p2 = planets[i + 1];
                int cost = Math.min(Math.abs(p1.x - p2.x),
                        Math.min(Math.abs(p1.y - p2.y), Math.abs(p1.z - p2.z)));
                edges.add(new Edge(p1.index, p2.index, cost));
            }
        }

        Collections.sort(edges);

        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int totalCost = 0;

        for(Edge e : edges) {
            if(union(e.from, e.to)) {
                totalCost += e.cost;
            }
        }

        System.out.println(totalCost);
    }
}