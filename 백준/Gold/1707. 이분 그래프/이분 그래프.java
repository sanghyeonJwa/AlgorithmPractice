import java.util.*;
import java.io.*;

public class Main {

    static List<Integer>[] graph;
    static int[] visited;
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        for (int t = 0; t < k; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());   // vertex
            int e = Integer.parseInt(st.nextToken());   // edge

            graph = new ArrayList[v + 1];
            visited = new int[v + 1];
            isBipartite = true;

            for (int i = 1; i <= v; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph[u].add(w);
                graph[w].add(u);
            }

            for (int i = 1; i <= v; i++) {
                if (visited[i] == 0) {
                    if (!dfs(i, 1)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    public static boolean dfs(int node, int color) {
        visited[node] = color;

        for (int next : graph[node]) {
            if (visited[next] == 0) {
                if (!dfs(next, -color)) return false;
            } else if (visited[next] == visited[node]) {
                return false;
            }
        }

        return true;
    }
}

